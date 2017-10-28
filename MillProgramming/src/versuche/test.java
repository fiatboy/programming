package versuche;



import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class test {
		@FXML
		public GridPane Board;
		public GridPane ShipsToBePlaced;
		public Rectangle MessageBox;
		public Button ReadyButton;
		public Button QuitButton;
		public ImageView[][] water;
		public ImageView[] ships;
		public ImageView[][] ships2d;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		    //Adds water to each cell in grid
		    water = new ImageView[10][10];
		    //ships2d = new ImageView[10][10];
		    for(int i =0; i<10; i++){
		        for(int j=0; j <10; j++){
		            water[i][j] = new ImageView("Tiles/watertile.png");
		            water[i][j].setPreserveRatio(true);
		            water[i][j].setFitHeight(49);
		            water[i][j].setFitWidth(49);
		            Board.add(water[i][j], i, j);
		            //ships2d[i][j] = new ImageView("Ships/ship2.png");
		            //ships2d[i][j].setPreserveRatio(true);
		            //ships2d[i][j].setFitWidth(49);
		            //Board.add(ships2d[i][j], i, j);

		        }
		    }
		    //Adds ships
		    ships = new ImageView[5];
		    ships[0] = new ImageView("Ships/ship2.png");
		    ships[1] = new ImageView("Ships/ship3.png");
		    ships[2] = new ImageView("Ships/ship3.png");
		    ships[3] = new ImageView("Ships/ship4.png");
		    ships[4] = new ImageView("Ships/ship5.png");
		    for(int i=0; i < 5; i++){
		        ships[i].setPreserveRatio(true);
		    }
		    ships[0].setFitWidth(80);
		    ships[1].setFitWidth(120);
		    ships[2].setFitWidth(120);
		    ships[3].setFitWidth(160);
		    ships[4].setFitWidth(200);
		    //ShipsToBePlaced.add(ships[0], 0, 0);
		    ShipsToBePlaced.add(ships[1], 0, 1);
		    ShipsToBePlaced.add(ships[2], 0, 2);
		    ShipsToBePlaced.add(ships[3], 0, 3);
		    ShipsToBePlaced.add(ships[4], 0, 4);


		    //Test imageview for dropped ship
		    ImageView test = new ImageView("Ships/ship2.png");
		    test.setPreserveRatio(true);
		    test.setFitWidth(80);


		    //First attempt at drag and drop
		    ImageView source = new ImageView ("Ships/ship2.png");
		    source.setPreserveRatio(true);
		    source.setFitWidth(80);
		    ShipsToBePlaced.add(source, 0, 0);
		    final GridPane target = Board;

		    //Drag detected event handler is used for adding drag functionality to the boat node
		    source.setOnDragDetected(new EventHandler<MouseEvent>() {
		        public void handle(MouseEvent event) {
		            //Drag was detected, start drap-and-drop gesture
		            //Allow any transfer node
		            Dragboard db = source.startDragAndDrop(TransferMode.ANY);

		            //Put ImageView on dragboard
		            ClipboardContent cbContent = new ClipboardContent();
		            cbContent.putImage(source.getImage());
		            //cbContent.put(DataFormat.)
		            db.setContent(cbContent);
		            source.setVisible(false);
		            event.consume();
		        }
		    });

		    //Drag over event handler is used for the receiving node to allow movement
		    target.setOnDragOver(new EventHandler<DragEvent>() {
		        public void handle(DragEvent event) {
		            //data is dragged over to target
		            //accept it only if it is not dragged from the same node
		            //and if it has image data
		            if(event.getGestureSource() != target && event.getDragboard().hasImage()){
		                //allow for moving
		                event.acceptTransferModes(TransferMode.MOVE);
		            }
		            event.consume();
		        }
		    });

		    //Drag entered changes the appearance of the receiving node to indicate to the player that they can place there
		    target.setOnDragEntered(new EventHandler<DragEvent>() {
		        public void handle(DragEvent event) {
		            //The drag-and-drop gesture entered the target
		            //show the user that it is an actual gesture target
		            if(event.getGestureSource() != target && event.getDragboard().hasImage()){
		                source.setVisible(false);
		                target.setOpacity(0.7);
		                System.out.println("Drag entered");
		            }
		            event.consume();
		        }
		    });

		    //Drag exited reverts the appearance of the receiving node when the mouse is outside of the node
		    target.setOnDragExited(new EventHandler<DragEvent>() {
		        public void handle(DragEvent event) {
		            //mouse moved away, remove graphical cues
		            source.setVisible(true);
		            target.setOpacity(1);

		            event.consume();
		        }
		    });

		    //Drag dropped draws the image to the receiving node
		    target.setOnDragDropped(new EventHandler<DragEvent>() {
		        public void handle(DragEvent event) {
		            //Data dropped
		            //If there is an image on the dragboard, read it and use it
		            Dragboard db = event.getDragboard();
		            boolean success = false;
		            int x, y;
		            if(db.hasImage()){
		                //target.setText(db.getImage()); --- must be changed to target.add(source, col, row)
		                //target.add(source, 5, 5, 1, 1);
		                //Places at 0,0 - will need to take coordinates once that is implemented
		                Board.add(test, 0, 0, 1, 1);
		                success = true;
		            }
		            //let the source know whether the image was successfully transferred and used
		            event.setDropCompleted(success);

		            event.consume();
		        }
		    });

		    source.setOnDragDone(new EventHandler<DragEvent>() {
		        public void handle(DragEvent event) {
		            //the drag and drop gesture has ended
		            //if the data was successfully moved, clear it
		            if(event.getTransferMode() == TransferMode.MOVE){
		                source.setVisible(false);
		            }
		            event.consume();
		        }
		    });
		}

}
