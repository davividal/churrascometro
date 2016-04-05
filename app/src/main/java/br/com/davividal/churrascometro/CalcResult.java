package br.com.davividal.churrascometro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CalcResult extends AppCompatActivity {
    public enum Quantity {
        MAN(450, 500),
        WOMAN(250, 300),
        CHILD(200, 200);

        private Integer linguica;
        private Integer carne;

        Quantity(Integer linguica, Integer carne) {
            this.linguica = linguica;
            this.carne = carne;
        }

        public Integer getCarne(Integer ppl) {
            return ppl * this.carne;
        }

        public Integer getLinguica(Integer ppl) {
            return ppl * this.linguica;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView qtyLinguica = (TextView) findViewById(R.id.qtyLinguica);
        TextView qtyCarne = (TextView) findViewById(R.id.qtyCarne);

        Intent it = getIntent();

        if (null != it) {
            Bundle params = it.getExtras();

            if (null != params) {
                Integer carne = Quantity.MAN.getCarne(params.getInt("men")) +
                        Quantity.WOMAN.getCarne(params.getInt("women")) +
                        Quantity.CHILD.getCarne(params.getInt("children"));
                Integer linguica = Quantity.MAN.getLinguica(params.getInt("men")) +
                        Quantity.WOMAN.getLinguica(params.getInt("women")) +
                        Quantity.CHILD.getLinguica(params.getInt("children"));

                qtyCarne.setText(new Peso(carne).toString());
                qtyLinguica.setText(new Peso(linguica).toString());
            }
        }
    }

}
