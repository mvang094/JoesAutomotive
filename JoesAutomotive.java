import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
    This class will demonstrate an automotive shop's business transaction.
    Joe's Automotive will calculate each service and submit a grand total
    at the end
 */

public class JoesAutomotive extends Application
{
    private Label chargeTotal;
    private Button oil, lube, radiator, transmission, inspect, muffler, tire;
    private double allTotal = 0;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Label parts, hours, serviceTotal;
        Button addParts = new Button("Add Parts Charge");
        Button addLabor = new Button("Add Labor Charge");
        TextField partsField = new TextField("0.00");
        TextField laborField = new TextField("0");

        oil = new Button("Oil Change: $35");
        lube = new Button("Lube Job : $25");
        radiator = new Button("Radiator Flush: $50");
        transmission = new Button("Transmission Flush: $120");
        inspect = new Button("Inspection $35");
        muffler = new Button("Muffler Replacement: $200");
        tire = new Button("Tire Rotation: $20");

        parts = new Label("Parts:");
        hours = new Label("Hours Labor:");
        serviceTotal = new Label("Total: ");
        chargeTotal = new Label("0.00");

        oil.setOnAction(new GetTotal());
        lube.setOnAction(new GetTotal());
        radiator.setOnAction(new GetTotal());
        transmission.setOnAction(new GetTotal());
        inspect.setOnAction(new GetTotal());
        muffler.setOnAction(new GetTotal());
        tire.setOnAction(new GetTotal());

        //I wanted to try and use an Anonymous Inner Class for practice, so
        //I used them with the following two buttons

        /**
            The following is an anonymous class that handles the event when the
            addParts button is clicked.
        */
        addParts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double partsInput = Double.parseDouble(partsField.getText());
                allTotal += partsInput;
                chargeTotal.setText(Double.toString(allTotal));
            }
        });

        /**
         The following is an anonymous class that handles the event when the
         addLabor button is clicked.
         */
        addLabor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int laborInput = Integer.parseInt(laborField.getText());
                allTotal += (laborInput*60);
                chargeTotal.setText(Double.toString(allTotal));
            }
        });

        VBox serviceBtns = new VBox(10, oil, lube, radiator, transmission,
                inspect, muffler, tire);
        serviceBtns.setAlignment(Pos.CENTER);

        HBox partsCharge = new HBox(10, parts, partsField, addParts);
        partsCharge.setAlignment(Pos.CENTER);
        HBox laborCharge = new HBox(10, hours, laborField, addLabor);
        laborCharge.setAlignment(Pos.CENTER);
        HBox totalCharge = new HBox(10, serviceTotal, chargeTotal);

        VBox allContent = new VBox(10, serviceBtns, partsCharge, laborCharge, totalCharge);

        Scene scene = new Scene(allContent, 360, 350);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Joe's Automotive");
        primaryStage.show();
    }

    /**
     * The GetTotal class is the event handler function for when
     * the buttons for oil, lube, transmission, tire, radiator,
     * inspect and/or muffler is/are clicked. If clickec/an event
     * happens, the function will responded by adding the appropriate
     * amount to the total and displying on the GUI
     */
    private class GetTotal implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(event.getSource() == oil)
            {
                allTotal += 35;
                chargeTotal.setText(Double.toString(allTotal));
            }

            else if(event.getSource() == lube)
            {
                allTotal += 25;
                chargeTotal.setText(Double.toString(allTotal));
            }

            else if(event.getSource() == radiator)
            {
                allTotal += 50;
                chargeTotal.setText(Double.toString(allTotal));
            }

            else if(event.getSource() == transmission)
            {
                allTotal += 120;
                chargeTotal.setText(Double.toString(allTotal));
            }
            else if(event.getSource() == inspect)
            {
                allTotal += 35;
                chargeTotal.setText(Double.toString(allTotal));
            }
            else if(event.getSource() == muffler) {
                allTotal += 200;
                chargeTotal.setText(Double.toString(allTotal));
            }
            else if(event.getSource() == tire)
            {
                allTotal += 20;
                chargeTotal.setText(Double.toString(allTotal));
            }
        }
    }
}
