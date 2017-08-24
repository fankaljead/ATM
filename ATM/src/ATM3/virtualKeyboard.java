package ATM3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class virtualKeyboard extends Application{
    private BorderPane borderPane = new BorderPane();
    private HBox hBoxOfGridPane = new HBox();
    private GridPane gridPane = new GridPane();

    private Button[] bt = new Button[12];

    private Text text = new Text("");
    private TextInputControl control;

    /**
     * �������
     * @return
     */
    public BorderPane getPane(){
        return borderPane;
    }

    /**
     * ����ָ���ı�
     * @param control
     */
    public void setControl(TextInputControl control){
        this.control = control;
    }

    /**
     * ���캯��
     */
    public virtualKeyboard(){
        setUI();
        handler();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(getPane(), 500, 500));
        primaryStage.show();
    }

    /**
     * ������弰���
     */
    private void setUI(){
        //����ˮƽ���Ϊ5
        gridPane.setHgap(5);
        //���ô�ֱ���Ϊ5
        gridPane.setVgap(5);

        //���ð�ť���Ϊ50
        double width = 40;
        //���ð�ť�߶�Ϊ100
        double height = 80;

        //���ð�ťԤ�衢������С��ȼ��߶�
        for(int i = 0; i < bt.length; i++){
            bt[i] = new Button();//��ʼ��
            bt[i].setPrefHeight(width);
            bt[i].setPrefWidth(height);
            bt[i].setMaxHeight(bt[i].getPrefHeight());
            bt[i].setMaxWidth(bt[i].getPrefWidth());
            bt[i].setMinHeight(bt[i].getPrefHeight());
            bt[i].setMinWidth(bt[i].getPrefWidth());
            bt[i].setStyle("-fx-font: 20 arial;-fx-base: #FFFFFF; ");
        }

        //�����ı����塢��ϸ�ʹ�С
        text.setFont(Font.font("times", FontWeight.BOLD, FontPosture.ITALIC, 20));

        //���ð�ť���ı�
        for(int i = 0; i < 12; i++){
            switch (i){
                case 9: text.setText(".");break;
                case 10: text.setText("0");break;
                case 11: text.setText("Del");break;
                default:text.setText(i + 1 + "");break;
            }

            bt[i].setText(text.getText());
        }

        //����ť������gridPane��
        int index = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                gridPane.add(bt[index], j, i);
                index++;
            }
        }

        //��gridPane������borderPane�ĵײ�����
        hBoxOfGridPane.setAlignment(Pos.CENTER);
        hBoxOfGridPane.getChildren().addAll(gridPane);
        borderPane.setPadding(new Insets(5, 5, 5, 5));
        borderPane.setBottom(hBoxOfGridPane);

    }

    private void handler(){
        bt[0].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[0].getText());
            text.setText(this.control.getText());
        });
        bt[1].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[1].getText());
            text.setText(this.control.getText());
        });
        bt[2].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[2].getText());
            text.setText(this.control.getText());
        });
        bt[3].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[3].getText());
            text.setText(this.control.getText());
        });
        bt[4].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[4].getText());
            text.setText(this.control.getText());
        });
        bt[5].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[5].getText());
            text.setText(this.control.getText());
        });
        bt[6].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[6].getText());
            text.setText(this.control.getText());
        });
        bt[7].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[7].getText());
            text.setText(this.control.getText());
        });
        bt[8].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[8].getText());
            text.setText(this.control.getText());
        });
        bt[9].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[9].getText());
            text.setText(this.control.getText());
        });
        bt[10].setOnAction(e ->{
            this.control.setText(this.control.getText() + bt[10].getText());
            text.setText(this.control.getText());
        });
        bt[11].setOnAction(e ->{
            String string = this.control.getText();
            if(string.length() > 0) {
                this.control.setText(string.substring(0, string.length() - 1));
                text.setText(this.control.getText());
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
