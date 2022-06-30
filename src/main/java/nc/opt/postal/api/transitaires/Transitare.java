package nc.opt.postal.api.transitaires;

import java.text.Normalizer;

public record Transitare(String name, String phone, String email, String website, String facebook) {
    public String getId() {
        return Normalizer
            .normalize(name, Normalizer.Form.NFD)
            .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
            .replaceAll("\\W+", "_")
            .toUpperCase();
    }
}
