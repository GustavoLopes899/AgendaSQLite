package br.edu.ifsp.agendasqlite.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.agendasqlite.R;
import br.edu.ifsp.agendasqlite.data.ContatoDAO;
import br.edu.ifsp.agendasqlite.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_salvarContato) {
            ContatoDAO dao = new ContatoDAO(this);

            String nome = ((EditText) findViewById(R.id.editTextNome)).getText().toString();
            String fone1 = ((EditText) findViewById(R.id.editTextFone1)).getText().toString();
            String fone2 = ((EditText) findViewById(R.id.editTextFone2)).getText().toString();
            String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();

            Contato c = new Contato(nome, fone1, fone2, email);

            int idContato = (int) dao.incluirContato(c);
            c.setId(idContato);

            MainActivity.adapter.adicionaContatoAdapter(c);

            Toast.makeText(getApplicationContext(), "Contato inserido", Toast.LENGTH_LONG).show();

            finish();


        }

        return super.onOptionsItemSelected(item);
    }


}
