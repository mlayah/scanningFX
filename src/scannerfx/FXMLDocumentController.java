/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author dan
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private ImageView img1;
    @FXML
    private Label lbl1;
    @FXML
    private ImageView img2;
    @FXML
    private Label lbl2;
    @FXML
    private ImageView img3;
    @FXML
    private Label lbl3;
    @FXML
    private ImageView img4;
    @FXML
    private Label lbl4;
    @FXML
    private ImageView img5;
    @FXML
    private Label lbl5;
    @FXML
    private ImageView img6;
    @FXML
    private Button btnScan;
    @FXML
    private Text txt1;
    @FXML
    private Text txt3;
    @FXML
    private Text txt4;
    @FXML
    private Text txt6;
    @FXML
    private Text txt2;
    @FXML
    private Text txt5;
    private RotateTransition rotateTransition1, rotateTransition2, rotateTransition3,
            rotateTransition4, rotateTransition5, rotateTransition6;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void beginAnimation(ActionEvent event) {
        img1.setImage(new Image("imgs/synching.png"));
        txt1.setText("Checking for updates");
        rotateTransition1 = new RotateTransition(Duration.seconds(5), img1);
        rotateTransition2 = new RotateTransition(Duration.seconds(5), img2);
        rotateTransition3 = new RotateTransition(Duration.seconds(5), img3);
        rotateTransition4 = new RotateTransition(Duration.seconds(5), img4);
        rotateTransition5 = new RotateTransition(Duration.seconds(5), img5);
        rotateTransition6 = new RotateTransition(Duration.seconds(5), img6);

        RotateTransition[] transition = {rotateTransition1, rotateTransition2,
            rotateTransition3, rotateTransition4,
            rotateTransition5, rotateTransition6};

        for (RotateTransition rotateTransition : transition) {
            rotateTransition.setCycleCount(1);
            rotateTransition.setAutoReverse(false);
            rotateTransition.setFromAngle(720);
            rotateTransition.setToAngle(0);
        }

        // Set up sequential plays
        rotateTransition1.setOnFinished((ActionEvent event1) -> {
            img1.setImage(new Image("imgs/ok.png"));
            lbl1.setStyle("-fx-background-color:#47A563");
            img2.setImage(new Image("imgs/synching.png"));
            txt2.setText("Pre-scan Operations");
            rotateTransition2.play();
        });
        rotateTransition1.play();

        rotateTransition2.setOnFinished((ActionEvent event2) -> {
            img2.setImage(new Image("imgs/ok.png"));
            lbl2.setStyle("-fx-background-color:#47A563");
            img3.setImage(new Image("imgs/synching.png"));
            txt3.setText("Scanning Memory");
            rotateTransition3.play();
        });

        rotateTransition3.setOnFinished((ActionEvent event2) -> {
            img3.setImage(new Image("imgs/ok.png"));
            lbl3.setStyle("-fx-background-color:#47A563");
            img4.setImage(new Image("imgs/synching.png"));
            txt4.setText("Scanning Registry");
            rotateTransition4.play();
        });

        rotateTransition4.setOnFinished((ActionEvent event2) -> {
            img4.setImage(new Image("imgs/ok.png"));
            lbl4.setStyle("-fx-background-color:#47A563");
            img5.setImage(new Image("imgs/synching.png"));
            txt5.setText("Scanning file system");
            rotateTransition5.play();
        });

        rotateTransition5.setOnFinished((ActionEvent event2) -> {
            img5.setImage(new Image("imgs/ok.png"));
            lbl5.setStyle("-fx-background-color:#47A563");
            img6.setImage(new Image("imgs/synching.png"));
            txt6.setText("Heuristics Analysis");
            rotateTransition6.play();
        });
        rotateTransition6.setOnFinished((ActionEvent event2) -> {
            img6.setImage(new Image("imgs/ok.png"));

        });

    }

}
