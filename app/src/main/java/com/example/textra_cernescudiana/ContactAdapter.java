package com.example.textra_cernescudiana;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> lista;

    public ContactAdapter(List<Contact> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Contact getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl= LayoutInflater.from(parent.getContext());
        View item= infl.inflate(R.layout.item_contacte,parent,false);
        TextView t_nume= item.findViewById(R.id.nume);
        TextView t_nrTelefon= item.findViewById(R.id.nr_telefon);

        Contact current= lista.get(position);
        t_nume.setText(current.getNume());
        t_nrTelefon.setText(current.getNr_telefon());

        return item;
    }
    public void update_list(List<Contact> lista_noua)
    {
        this.lista.clear();
        this.lista.addAll(lista_noua);
        notifyDataSetChanged();

    }
}
