package nc.opt.postal.api.transitaires;

public record Transitaire(String id, String name, String phone, String email, String website, String facebook, String ridet) {
    public static record Scored(Transitaire transitaire, long score) implements Comparable<Scored> {

        @Override
        public int compareTo(Scored o) {
            return Long.compare(this.score, o.score);
        }
    }
}
