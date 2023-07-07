public class Book {
        String title;
        String author;
        String publisher;
        double price;
        public Book(String title, String author, String publisher, double price) {
                this.title = title;
                this.author = author;
                this.publisher = publisher;
                this.price = price;
        }
        @Override
        public String toString() {
            return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + "]";
        }
}
