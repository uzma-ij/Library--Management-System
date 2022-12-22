package com.example.secondsemesterfinalproject2ndtime;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloApplication extends Application { // start of class
public int f=0;

    String[] p = new String[4];
    @Override              // duplicate children added means two same things are added
    public void start(Stage stage) throws IOException { // start of start method

        GridPane gridPane= new GridPane();

        // gridPane.setBorder(new Border(new BorderImage()));
        gridPane.setBackground(new Background(new BackgroundFill(Color.LINEN, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Alert a = new Alert(Alert.AlertType.WARNING); // super class of dialog class
         Label l1,l2,l3,l7;
         TextField t1;
        Button b1;
        PasswordField p1= new PasswordField();

        l7= new Label("change password?");

             if(f==0) {
                 FileWriter fileWriter3 = new FileWriter("password.txt");
                 Password[] passwords = new Password[2];
                 passwords[0] = new Password("uzma123");
                 passwords[1] = new Password("sheeza123");
                 for (int n = 0; n < 2; n++) {
                     fileWriter3.write(String.valueOf(passwords[n]));
                 }
                 fileWriter3.close();
             }
      // b2.setFont(Font.font("Calibre", FontWeight.BOLD,24));
        b1= new Button("LOGIN");

        l1= new Label("Login");
        l1.setFont(Font.font("Lucid Handwriting", FontWeight.BOLD,24));
        l2= new Label("Username");
        l2.setFont(Font.font("Calibre",FontWeight.SEMI_BOLD,15));
        l2.setTextFill(Color.BLACK);
        l3= new Label("Password");
        l3.setFont(Font.font("Calibre",FontWeight.SEMI_BOLD, 16));
        l3.setTextFill(Color.BLACK);
       // b1.setTextFill(Color.BLACK);
        t1= new TextField();
         l7.setFont(Font.font("Calibre",FontWeight.BOLD, 16));
       // b1.setStyle("-fx-background-color:  #00ff00");
      //  b1.setBackground(new Background(new BackgroundFill(Color.TURQUOISE,CornerRadii.EMPTY,Insets.EMPTY)));
        gridPane.add(l1,7,5);
        gridPane.add(l2,4,10);
        gridPane.add(t1,7,10);
        gridPane.add(l3,4,13);
        gridPane.add(p1,7,13);
        gridPane.add(b1,7,18);
        gridPane.add(l7,7,19);

           b1.setFont(Font.font(String.valueOf(Color.BLACK),FontWeight.BOLD,18));
       // l7.setFont(Font.font("Congenial SemiBold",FontWeight.SEMI_BOLD,30));
      //  b1.setTextFill(Color.CADETBLUE);  // setting the colour of text on button
        b1.setPrefSize(300,30);  //setting the size of button
        stage.setHeight(500);
        stage.setWidth(500);
        Scene scene= new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("login");
        stage.show();


            BufferedReader reader;
            reader = new BufferedReader(new FileReader("password.txt"));
            for (int n2 = 0; n2 < 4; n2++) {
                p[n2] = reader.readLine();
               // System.out.printf(p[n2] + "\n");
            }
            reader.close();

            EventHandler<MouseEvent> handler2= new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent mouseEvent) {
               if(mouseEvent.getSource()==l7){
                   stage.close();
                   try {
                       start2();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               }
            //   mouseEvent2.consume();
           }
       };
       l7.setOnMouseClicked(handler2);
        // event handler is a class
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getSource() == b1) {
                    if( ((t1.getText().equals("sp22-bcs-069")) &&((p1.getText().equals(p[0])) ||(p1.getText().equals(p[2])))) || (( t1.getText().equals("sp22-bcs-096")) &&((p1.getText().equals(p[1]))||(p1.getText().equals(p[3])))))
                    {                 // do not use == symbol for strings
                        stage.close();
                        try {
                            start1();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else {
                        a.setAlertType(Alert.AlertType.ERROR);
                        a.show();
                    }
                }
                mouseEvent.consume();
            }
        };
        b1.setOnMouseClicked(handler);

    }  // end of start method
    public void start2() throws IOException {
        f=f+1;
        Stage stage2= new Stage();
        GridPane gridPane2= new GridPane();
        Scene scene2= new Scene(gridPane2);
        gridPane2.setHgap(12);
        gridPane2.setVgap(12);
        gridPane2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,CornerRadii.EMPTY,Insets.EMPTY)));

        Label label= new Label("old password");
        Label label1= new Label("new password");
        label.setFont(Font.font("Calibri",FontWeight.BOLD,20));
        label.setTextFill(Color.BLACK);
        label1.setFont(Font.font("Calibri",FontWeight.BOLD,20));
        label1.setTextFill(Color.BLACK);
        TextField t3, t4;
        Button button;
        button= new Button("back");
        button.setPrefSize(100,30);
        button.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
       // button.setTextFill(Color.BLACK);
        button.setFont(Font.font(String.valueOf(Color.BROWN),FontWeight.BOLD,15));
       // button.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
        gridPane2.add(button,10,28);
        t3= new TextField();
        t4= new TextField();
        gridPane2.add(t3,8,4);
        gridPane2.add(t4,8,14);
        gridPane2.add(label,6,4);
        gridPane2.add(label1,6,14);
        stage2.setWidth(520);
        stage2.setHeight(500);
        stage2.setTitle("new window");
        stage2.setScene(scene2);
        stage2.show();
        EventHandler<MouseEvent> handler4= new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               if(mouseEvent.getSource()==button) {
                   String s1 = t3.getText();
                   System.out.println("printing s1" + s1);
                   int num = 0;
                  // String[] p = new String[2];
                   Scanner sc;
                   try {
                       sc = new Scanner(new File("password.txt"));
                   } catch (FileNotFoundException e) {
                       throw new RuntimeException(e);
                   }
                   StringBuffer buffer = new StringBuffer();
                   //Reading lines of the file and appending them to StringBuffer
                   while (sc.hasNextLine()) {
                       buffer.append(sc.nextLine() + System.lineSeparator());
                   }
                   String fileContents = buffer.toString();
                   System.out.println("Contents of the file: "+fileContents);
                   sc.close();

                   String s2 = t4.getText();
                   System.out.println(s2);
                   String  oldname=s1;
                   String newname=s2;
                   fileContents=fileContents.replaceAll(oldname,newname);

                   FileWriter fileWriter3 = null;
                   try {
                       fileWriter3 = new FileWriter("password.txt", true);
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   System.out.println("new data: "+fileContents);

                   try {
                       fileWriter3.append(fileContents);
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }

                   try {
                       fileWriter3.flush();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   try {
                       fileWriter3.close();
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   stage2.close();

                   try {
                       start(new Stage());
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
               }
            }
        };
        button.setOnMouseClicked(handler4);
    }
     // end of start method

     public void start1() throws IOException{ // start of another method start1
        FileWriter fileWriter= new FileWriter("hy.txt");
        FileWriter fileWriter1= new FileWriter("hy1.txt");
        FileWriter fileWriter2= new FileWriter("hy2.txt");
        books[] j= new books[3];
        j[0]= new books("java how to program","harry robert",8);
        j[1]= new books("java how to program","harry robert",5);
        j[2]= new books("java how to program","harry robert",11);
        books[] ds= new books[4];
        ds[0]= new books("descrete structures","John",2);
        ds[1]= new books("descrete structures","John",9);
        ds[2]= new books("descrete structures","John",4);
        books[] dld= new books[4];
        dld[0]= new books("digital logic design","alpha",15);
        dld[1]= new books("digital logic design","apha",19);
        dld[2]= new books("digital logic design","alpha",9);

        for(int n=0; n<3;n++){
            fileWriter.write(String.valueOf(j[n]));
        }
        for(int n1=0;n1<3;n1++){
            fileWriter1.write(String.valueOf(ds[n1]));
        }
        for(int n2=0;n2<3;n2++) {
            fileWriter2.write(String.valueOf(dld[n2]));
        }
        fileWriter.close();
        fileWriter1.close();
        fileWriter2.close();

        Text text= new Text();
        Stage stage1= new Stage();
        GridPane gridPane1= new GridPane();
        gridPane1.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,CornerRadii.EMPTY,Insets.EMPTY)));
        gridPane1.setHgap(10);gridPane1.setVgap(10);
        TextField  t1= new TextField();
        t1.setPrefSize(386,20);
        gridPane1.add(t1,3,3);
        Button butt=  new Button("Locate");
        Button b,button;
           button= new Button("Sort");

         butt.setPrefSize(80,25);
       //  butt.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH,CornerRadii.EMPTY,Insets.EMPTY)));
          butt.setTextFill(Color.BROWN);
         butt.setFont(Font.font(String.valueOf(Color.BROWN),FontWeight.BOLD,15));
           text.setFont(Font.font(String.valueOf(Color.BLACK),FontWeight.SEMI_BOLD,15));
        b= new Button("search");
         b.setPrefSize(80,25);
         b.setTextFill(Color.BROWN);
         b.setFont(Font.font(String.valueOf(Color.BROWN),FontWeight.BOLD,15));
        gridPane1.add(b,4,3);
        gridPane1.add(butt,4,4);
        Label label1=new Label();
        EventHandler<MouseEvent> handler4= new EventHandler<MouseEvent>() {@Override
            public void handle(MouseEvent mouseEvent) {
            if((mouseEvent.getSource()==butt) &&(t1.getText().equals("java how to program"))){
                label1.setText("CS department shelf no. 3");
                label1.setFont(Font.font("Calibre", FontWeight.BOLD,24));
                label1.setTextFill(Color.BROWN);
                gridPane1.add(label1,3,6);
                }
                if((mouseEvent.getSource()==butt) &&(t1.getText().equals("descrete structures"))){
                  label1.setText("location: SE department Shelf no. 5");
                    label1.setFont(Font.font("Calibre", FontWeight.BOLD,24));
                    label1.setTextFill(Color.BROWN);
                    gridPane1.add(label1,3,6);
                }
                if((mouseEvent.getSource()==butt)&&(t1.getText().equals("digital logic design"))){
                    label1.setText("location: EE department Shelf no. 8");
                    label1.setFont(Font.font("Calibre", FontWeight.BOLD,24));
                    label1.setTextFill(Color.BROWN);
                    gridPane1.add(label1,3,6);
                }
        }

        };
        butt.setOnMouseClicked(handler4);


        EventHandler<MouseEvent> handler1= new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getSource() == b) {
                     if (t1.getText().equals("java how to program")) {
                         List<String> stringList = new ArrayList<String>();
                        Scanner sc = null;
                        try {
                            sc = new Scanner(new FileReader("hy.txt")).useDelimiter(",\s*");
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        String str;
                        while (sc.hasNext()) {
                            str = sc.next();
                            stringList.add(str);
                        }
                      //  Text text = new Text();
                        String[] array = stringList.toArray(new String[0]);
                        for (String each : array) {
                            text.setFont(new Font("Calibre",20));
                            text.setText(each);
                        }
                        gridPane1.add(text, 3, 7);
                    }
                        if (t1.getText().equals("descrete structures")) {

                            List<String> stringList = new ArrayList<String>();
                            Scanner sc = null;
                            try {
                                sc = new Scanner(new FileReader("hy1.txt")).useDelimiter(",\s*");
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            String str;
                            while (sc.hasNext()) {
                                str = sc.next();
                                stringList.add(str);
                            }
                          //  Text text = new Text();
                            String[] array = stringList.toArray(new String[0]);
                            for (String each : array) {
                                text.setFont(new Font("Calibre", 20));
                                text.setText(each);
                            }

                            gridPane1.add(text, 3, 7);
                        }
                        if (t1.getText().equals("digital logic design")) {

                            List<String> stringList = new ArrayList<String>();
                            Scanner sc = null;
                            try {
                                sc = new Scanner(new FileReader("hy2.txt")).useDelimiter(",\s*");
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            String str;
                            while (sc.hasNext()) {
                                str = sc.next();
                                stringList.add(str);
                            }
                          //  Text text = new Text();
                            String[] array = stringList.toArray(new String[0]);
                            for (String each : array) {
                                text.setFont(new Font("Calibre", 20));
                                text.setText(each);
                            }
                            gridPane1.add(text, 3, 7);
                        }

                    }
                }
        };
        b.setOnMouseClicked(handler1);
        stage1.setWidth(540);
        stage1.setHeight(500);

        stage1.setTitle("new window");
        Scene scene1= new Scene(gridPane1);
        stage1.setScene(scene1);
        stage1.show();
    } // end of start1 method

    public static void main(String[] args) {
        launch();
    }
}

