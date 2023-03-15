package seedu.library.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.library.model.bookmark.Bookmark;
import javafx.scene.control.Hyperlink;

/**
 * An UI component that displays information of a {@code Bookmark}.
 */
public class BookmarkCard extends UiPart<Region> {

    private static final String FXML = "BookmarkListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/Library-level4/issues/336">The issue on Library level 4</a>
     */

    public final Bookmark bookmark;

    @FXML
    private HBox cardPane;
    @FXML
    private Label title;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label author;
    @FXML
    private Label genre;
    @FXML
    private FlowPane tags;
    @FXML
    private Button b1;
    @FXML
    private Hyperlink link;


    /**
     * Creates a {@code BookmarkCode} with the given {@code Bookmark} and index to display.
     */
    public BookmarkCard(Bookmark bookmark, int displayedIndex) {
        super(FXML);
        this.bookmark = bookmark;
        id.setText(displayedIndex + ". ");
        title.setText(bookmark.getTitle().value);
        phone.setText(bookmark.getPhone().value);
        b1.setText(bookmark.getPhone().toString());

        if (bookmark.getPhone().toString().equals("87438807")) {
            b1.setStyle("-fx-background-color: #50f60a");
        } else if (bookmark.getPhone().toString().equals("99272758")) {
             b1.setStyle("-fx-background-color: #eaf553");
        } else if (bookmark.getPhone().toString().equals("93210283")) {
            b1.setStyle("-fx-background-color: #d83434");
        } else {
            b1.setDisable(true);
            b1.setVisible(false);
        }
        /**
         * what its supposed to be:
         * if (bookmark.getProgress().toString().equals("Done")) {
         *     b1.setStyle("-fx-background-color: #50f60a");
         * } else if (bookmark.getProgress().toString().equals("In Progress")) {
         *     b1.setStyle("-fx-background-color: #eaf553");
         * } else if (bookmark.getProgress().toString().equals("Not Started")) {
         *     b1.setStyle("-fx-background-color: #d83434");
         * } else {
         *     b1.setDisable(true);
         *     b1.setVisible(false);
         *         }
         *
         *
         */
        author.setText(bookmark.getAuthor().value);
        genre.setText(bookmark.getGenre().value);
        bookmark.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof BookmarkCard)) {
            return false;
        }

        // state check
        BookmarkCard card = (BookmarkCard) other;
        return id.getText().equals(card.id.getText())
                && bookmark.equals(card.bookmark);
    }
}
