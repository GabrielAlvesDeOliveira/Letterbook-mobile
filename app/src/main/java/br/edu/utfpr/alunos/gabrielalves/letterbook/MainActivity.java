package br.edu.utfpr.alunos.gabrielalves.letterbook;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etTitulo;
    private EditText etAutor;
    private RadioGroup rgStatusLeitura;
    private Spinner spinnerGenero;
    private CheckBox cbFavorito;
    private Button btnLimpar;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);
        rgStatusLeitura = findViewById(R.id.rgStatusLeitura);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        cbFavorito = findViewById(R.id.cbFavorito);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.generos_livro,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(adapter);

        btnLimpar.setOnClickListener(v -> limparCampos());
        btnSalvar.setOnClickListener(v -> salvarLivro());
    }

    private void limparCampos() {
        etTitulo.setText("");
        etAutor.setText("");
        rgStatusLeitura.clearCheck();
        spinnerGenero.setSelection(0);
        cbFavorito.setChecked(false);

        Toast.makeText(this, "Campos limpos", Toast.LENGTH_SHORT).show();
    }

    private void salvarLivro() {
        String titulo = etTitulo.getText().toString().trim();
        String autor = etAutor.getText().toString().trim();

        if (titulo.isEmpty()) {
            Toast.makeText(this, "Preencha o título", Toast.LENGTH_SHORT).show();
            etTitulo.requestFocus();
            return;
        }

        if (autor.isEmpty()) {
            Toast.makeText(this, "Preencha o autor", Toast.LENGTH_SHORT).show();
            etAutor.requestFocus();
            return;
        }

        int idSelecionado = rgStatusLeitura.getCheckedRadioButtonId();
        if (idSelecionado == -1) {
            Toast.makeText(this, "Selecione o status de leitura", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioSelecionado = findViewById(idSelecionado);
        String statusLeitura = radioSelecionado.getText().toString();

        String genero = spinnerGenero.getSelectedItem().toString();
        boolean favorito = cbFavorito.isChecked();

        String mensagem = "Título: " + titulo
                + "\nAutor: " + autor
                + "\nStatus: " + statusLeitura
                + "\nGênero: " + genero
                + "\nFavorito: " + (favorito ? "Sim" : "Não");

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}