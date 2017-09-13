package ru.job4j.testwork;

/**
 * Created by VLADIMIR on 08.09.2017.
 */
public abstract class Persons {

    /**
     * Getter.
     * @return - name.
     */
    abstract String getName();

    /**
     * Getter.
     * @return - attribute.
     */
    abstract String getAttribute();

    /**
     * Getter.
     * @return - sign.
     */
    abstract int getSign();


    /**
     * Ask.
     */
    static class Ask extends Persons {

        /**
         * Name.
         */
        private final String name = "ASK";
        /**
         * Attribute.
         */
        private final String attribute = "BUY";
        /**
         * Sign.
         */
        private final int sign = -1;

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getAttribute() {
            return this.attribute;
        }

        @Override
        public int getSign() {
            return this.sign;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Ask ask = (Ask) o;

            if (sign != ask.sign) {
                return false;
            }
            if (name != null ? !name.equals(ask.name) : ask.name != null) {
                return false;
            }
            return attribute != null ? attribute.equals(ask.attribute) : ask.attribute == null;
        }

        @Override
        public int hashCode() {
            final int shift = 31;
            int result = name != null ? name.hashCode() : 0;
            result = shift * result + (attribute != null ? attribute.hashCode() : 0);
            result = shift * result + sign;
            return result;
        }
    }

    /**
     * Bid.
     */
    static class Bid extends Persons {

            /**
             * Name.
             */
            private final String name = "BID";
            /**
             * Attribute.
             */
            private final String attribute = "SELL";
            /**
             * Sign.
             */
            private final int sign = 1;

            @Override
            public String getName() {
                return this.name;
            }

            @Override
            public String getAttribute() {
                return this.attribute;
            }

            @Override
            public int getSign() {
                return this.sign;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }

                Bid bid = (Bid) o;

                if (sign != bid.sign) {
                    return false;
                }
                if (name != null ? !name.equals(bid.name) : bid.name != null) {
                    return false;
                }
                return attribute != null ? attribute.equals(bid.attribute) : bid.attribute == null;
            }

            @Override
            public int hashCode() {
                final int shift = 31;
                int result = name != null ? name.hashCode() : 0;
                result = shift * result + (attribute != null ? attribute.hashCode() : 0);
                result = shift * result + sign;
                return result;
            }
        }
}
