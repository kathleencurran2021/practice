import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

////////////////////////////////////////////////////////////////////////////////
// File:             Main.java
// Course:           CSC232B, Spring 2019
// Authors:          (your name and the names of other members of your group)
//
// Acknowledgements: (list anyone else other than your instructor who helped)
//                   (describe in detail the the ideas and help they provided)
//
// Online sources:   (include Web URLs and description of any information used)
////////////////////////////////////////////////////////////////////////////////

/**
 * 
 */
public class Main extends Application{


   private static final int FIELD_LABEL_WIDTH = 80;
   private static final int BUTTON_SPACING = 50;
   private static final int PADDING = 5;
   @Override
   
  
   
   public void start(Stage stage) throws Exception {
      // TODO Auto-generated method stub
      TextField author = new TextField();
      String authorFieldLabel = "Author :";
      
      Label authorLabel = new Label(authorFieldLabel);
      authorLabel.setPrefWidth(FIELD_LABEL_WIDTH);
      
    // HBox authorField = new HBox(authorLabel, author);
      
      HBox authorField = createField(author, authorFieldLabel);
      authorField.setPadding(new Insets(PADDING));
      
      TextField title = new TextField();
      String titleFieldLabel = "Title: ";
      HBox titleField = createField(title, titleFieldLabel);
      
      TextField publisher = new TextField();
      HBox publisherField = createField(publisher, "Publisher: ");
      publisherField.setPadding(new Insets(PADDING));
      
      TextField year = new TextField();
      HBox yearField = createField(year, "Year: ");
      yearField.setPadding(new Insets(PADDING));
      
      VBox fields  = new VBox (authorField, titleField, publisherField, yearField);
      
     
      Button ok = new Button("OK");
      ok.setOnAction(e -> {
         System.out.println("New biblography entry:");
         System.out.println(" Author = " +author.getText());
         System.out.println(" Title = " +title.getText());
         System.out.println(" Publisher = " +publisher.getText());
         System.out.println(" Year = " +year.getText());
      });
      
      
      Button exit = new Button("Exit");
      exit.setOnAction(e -> Platform.exit());
      
      HBox buttons = new HBox(ok, exit);
      buttons.setAlignment(Pos.CENTER);
      buttons.setSpacing(BUTTON_SPACING);
      buttons.setPadding(new Insets(PADDING));
      
      BorderPane root = new BorderPane();
      root.setCenter(fields);
      root.setBottom(buttons);
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Demo");
      stage.show();
      
   }
   /**
    * @param title
    * @param titleFieldLabel
    * @return
    */
   private HBox createField(TextField field, String labelText) {
      Label label = new Label(labelText);
      label.setPrefWidth(FIELD_LABEL_WIDTH);
      HBox titleField = new HBox(label, field);
      titleField.setPadding(new Insets(PADDING));
      return titleField;
   }
 public static void main(String [] args) {
      launch(args);
   }
}
