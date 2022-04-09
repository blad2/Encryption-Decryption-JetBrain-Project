class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        int result = 0;
        if (otherArticle.getSize() == this.size) {
            result = this.title.compareTo(otherArticle.getTitle());
        } else {
            result = Integer.compare(this.size, otherArticle.getSize());
        }
        return  result;
    }
}
