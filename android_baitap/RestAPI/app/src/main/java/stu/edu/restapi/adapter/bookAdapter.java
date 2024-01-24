package stu.edu.restapi.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import stu.edu.restapi.R;
import stu.edu.restapi.model.Book;
public class bookAdapter extends RecyclerView.Adapter<bookAdapter.ViewHolder> {

    private List<Book> books;
    private Context context;

    public bookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.txtIsbn.setText("ISBN: " + book.getIsbn());
        holder.txtTitle.setText("Title: " + book.getTitle());
        holder.txtAuthor.setText("Author: " + book.getAuthor());
        holder.txtEdition.setText("Edition: " + book.getEdition());
        holder.txtPublishYear.setText("Publish Year: " + book.getPublisheYear());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtIsbn, txtTitle, txtAuthor, txtEdition, txtPublishYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIsbn = itemView.findViewById(R.id.txt_isbn);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtAuthor = itemView.findViewById(R.id.txt_author);
            txtEdition = itemView.findViewById(R.id.txt_edition);
            txtPublishYear = itemView.findViewById(R.id.txt_publisheYear);
        }
    }

}
