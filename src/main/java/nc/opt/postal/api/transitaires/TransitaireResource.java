package nc.opt.postal.api.transitaires;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import nc.opt.postal.api.transitaires.Transitare.Scored;

@Path("/transitaires")
public class TransitaireResource {

    @Inject
    Jsonb jsonb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transitare> list(@QueryParam("q") String q) {
        List<Transitare> data = Arrays.asList(jsonb.fromJson(getClass().getResourceAsStream("/data.json"), Transitare[].class));
        if (q == null || q.isEmpty()) {
            return data;
        } else {
            return data
                .stream()
                .map(i -> new Scored(i, score(i, q)))
                .filter(r -> r.score() > 0)
                .sorted(Collections.reverseOrder())
                .map(Scored::transitaire)
                .toList();
        }
    }

    /**
     * Indique si au moins un champ contient un des mots, plus il y a de mots qui mathent plus le score est élevé
     */
    private long score(Transitare data, String q) {
        // le critère de recherche mot par mot sans accent, sans espace et en minuscule
        List<String> queryWords = Arrays.asList(normalize(q).toLowerCase().split("\\W+"));

        // les différents termes de l'objet sans accent et en minuscule
        List<String> dataTerms = Arrays
            .asList(data.name(), data.email(), data.phone(), data.website(), data.ridet())
            .stream()
            .filter(Objects::nonNull)
            .map(this::normalize)
            .map(String::toLowerCase)
            .toList();

        // plus les mots correspondent plus le score est élevée
        return dataTerms.stream().mapToLong(t -> queryWords.stream().filter(t::contains).count()).sum();
    }

    private String normalize(String value) {
        return Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}
