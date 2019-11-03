package br.edu.ifsp.agendasqlite.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.agendasqlite.R;
import br.edu.ifsp.agendasqlite.data.ContatoDAO;
import br.edu.ifsp.agendasqlite.model.Contato;

public class DetalheActivity extends AppCompatActivity {

    Contato c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        if (getIntent().hasExtra("contato")) {
            this.c = (Contato) getIntent().getSerializableExtra("contato");

            EditText nome = findViewById(R.id.editTextNome);
            nome.setText(c.getNome());

            EditText fone_1 = findViewById(R.id.editTextFone1);
            fone_1.setText(c.getFone_1());

            EditText fone_2 = findViewById(R.id.editTextFone2);
            fone_2.setText(c.getFone_2());

            EditText email = findViewById(R.id.editTextEmail);
            email.setText(c.getEmail());

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_alterarContato) {
            ContatoDAO dao = new ContatoDAO(this);

            String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
            String fone_1 = ((EditText) findViewById(R.id.editTextFone1)).getText().toString();
            String fone_2 = ((EditText) findViewById(R.id.editTextFone2)).getText().toString();
            String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();

            c.setNome(nome);
            c.setFone_1(fone_1);
            c.setFone_2(fone_2);
            c.setEmail(email);

            dao.alterarContato(c);
            Log.d("ID: ", Integer.toString(c.getId()));
            Log.d("NOME: ", c.getNome());

            MainActivity.adapter.atualizaContatoAdapter(c);

            Toast.makeText(getApplicationContext(), "Contato alterado", Toast.LENGTH_LONG).show();

            finish();
        }

        if (id == R.id.action_excluirContato) {
            ContatoDAO dao = new ContatoDAO(this);
            dao.excluirContato(c);
            MainActivity.adapter.apagaContatoAdapter(c);

            Toast.makeText(getApplicationContext(), "Contato excluído", Toast.LENGTH_LONG).show();
            finish();

        }


        return super.onOptionsItemSelected(item);
    }


}
