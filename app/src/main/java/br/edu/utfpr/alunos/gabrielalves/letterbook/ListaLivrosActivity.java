package br.edu.utfpr.alunos.gabrielalves.letterbook;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaLivrosActivity extends AppCompatActivity {

    private ArrayList<Livro> livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);

        livros = carregarLivros();

        ListView listViewLivros = findViewById(R.id.list_view_livros);
        LivroAdapter adapter = new LivroAdapter(this, livros);
        listViewLivros.setAdapter(adapter);

        listViewLivros.setOnItemClickListener((parent, view, position, id) -> {
            Livro livroClicado = livros.get(position);
            String mensagem = livroClicado.getTitulo() + " - " + livroClicado.getAutor()
                    + " (" + livroClicado.getAnoPublicacao() + ")";
            Toast.makeText(ListaLivrosActivity.this, mensagem, Toast.LENGTH_SHORT).show();
        });
    }

    private ArrayList<Livro> carregarLivros() {
        String[] titulos = getResources().getStringArray(R.array.titulos_livros);
        String[] autores = getResources().getStringArray(R.array.autores_livros);
        String[] generos = getResources().getStringArray(R.array.generos_livros);
        String[] anos = getResources().getStringArray(R.array.anos_livros);

        TypedArray capas = getResources().obtainTypedArray(R.array.capas_livros);

        ArrayList<Livro> lista = new ArrayList<>();
        for (int i = 0; i < titulos.length; i++) {
            int capaId = capas.getResourceId(i, 0);
            lista.add(new Livro(titulos[i], autores[i], generos[i], Integer.parseInt(anos[i]), capaId));
        }
        capas.recycle();

        return lista;
    }
}