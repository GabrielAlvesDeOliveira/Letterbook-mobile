package br.edu.utfpr.alunos.gabrielalves.letterbook;

import android.widget.ImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LivroAdapter extends ArrayAdapter<Livro> {

    public LivroAdapter(Context context, ArrayList<Livro> livros) {
        super(context, 0, livros);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_livro, parent, false);
        }

        Livro livro = getItem(position);

        ImageView imageCapa = convertView.findViewById(R.id.image_capa);
        TextView textTitulo = convertView.findViewById(R.id.text_titulo);
        TextView textAutor = convertView.findViewById(R.id.text_autor);
        TextView textGenero = convertView.findViewById(R.id.text_genero);
        TextView textAno = convertView.findViewById(R.id.text_ano);

        imageCapa.setImageResource(livro.getCapa());
        textTitulo.setText(livro.getTitulo());
        textAutor.setText(livro.getAutor());
        textGenero.setText(livro.getGenero());
        textAno.setText(String.valueOf(livro.getAnoPublicacao()));

        return convertView;
    }
}