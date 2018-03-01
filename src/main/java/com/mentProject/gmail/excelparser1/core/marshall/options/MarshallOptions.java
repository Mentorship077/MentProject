package com.mentProject.gmail.excelparser1.core.marshall.options;

public final class MarshallOptions {

    private int skip = 1;
    private int sheetIndex;


    public int getSheetIndex() {
        return sheetIndex;
    }

    public int getSkip() {
        return skip;
    }


    private MarshallOptions setSkip(int skip) {
        this.skip = skip;
        return this;
    }


    private MarshallOptions setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
        return this;
    }


    public static class MarshallOptionsBuilder {

        private int skip = 1;
        private int sheetIndex;

        private MarshallOptionsBuilder() {
        }


        public MarshallOptions build() {
            return new MarshallOptions()
                    .setSkip(skip)
                    .setSheetIndex(sheetIndex);
        }

        public static MarshallOptionsBuilder settings() {
            return new MarshallOptionsBuilder();
        }

        public MarshallOptionsBuilder skip(int skip) {
            this.skip = skip;
            return this;
        }

        public MarshallOptionsBuilder sheetIndex(int sheetIndex) {
            this.sheetIndex = sheetIndex;
            return this;
        }

    }

}
