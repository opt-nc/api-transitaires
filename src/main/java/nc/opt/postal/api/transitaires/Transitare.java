package nc.opt.postal.api.transitaires;

public record Transitare(String id, String name, String phone, String email, String website, String facebook) {
    public static record Scored(Transitare transitaire, long score) implements Comparable<Scored> {

        @Override
        public int compareTo(Scored o) {
            return Long.compare(this.score, o.score);
        }
    }
}
