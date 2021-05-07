package sg.edu.rp.c346.id20007649.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView cost;
    TextView number_of_people;
    ToggleButton yes_svc;
    ToggleButton yes_gst;
    TextView discount_given;
    Button yes_split;
    Button yes_reset;
    TextView total_bills;
    RadioGroup payment_type;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cost = findViewById(R.id.enter_amount);
        number_of_people = findViewById(R.id.num_people);
        yes_svc = findViewById(R.id.service);
        yes_gst = findViewById(R.id.gst);
        discount_given = findViewById(R.id.discount);
        yes_split = findViewById(R.id.split);
        yes_reset = findViewById(R.id.reset);
        payment_type = findViewById(R.id.payment);
        total_bills = findViewById(R.id.total_bill);




        yes_split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strBill = cost.getText().toString();

                double total_bill = 0.0;
                double costs = Double.parseDouble(strBill);
                String strDisplay = total_bills.getText().toString();
                int strRadio = payment_type.getCheckedRadioButtonId();

                if (yes_svc.isChecked() && !yes_gst.isChecked()) {
                    total_bill = costs * 1.1;
                }
                else if (!yes_svc.isChecked() && yes_gst.isChecked()) {
                    total_bill = costs * 1.07;
                }
                else if (yes_svc.isChecked() && yes_gst.isChecked()) {
                    total_bill = costs * 1.17;

                }

                String nums = number_of_people.getText().toString();
                double num = Double.parseDouble(nums);

                double each = total_bill / num;



                if (strRadio == R.id.cash) {
                    strDisplay = "Total Bill: $" + total_bill ;
                    strDisplay += "Each pays: " + num + " in cash."

                }
                else{
                    strDisplay = "Total Bill: $" + total_bill + num + " via PayNow to 912345678"
                }

                total_bills.setText(strDisplay);

        }
        });

        yes_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cost.setValue = " ";







            }
        });










    }
}