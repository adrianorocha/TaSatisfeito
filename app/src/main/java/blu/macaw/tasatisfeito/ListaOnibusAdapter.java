package blu.macaw.tasatisfeito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Adriano on 07/02/2015.
 */
public class ListaOnibusAdapter extends ArrayAdapter<Onibus> {
    private Context context;
    private List<Onibus> onibusLista = null;

    public ListaOnibusAdapter(Context context, List<Onibus> onibusLista){
        super(context,0,onibusLista);
        this.onibusLista = onibusLista;
        this.context = context;
    }
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        Onibus onibus = onibusLista.get(position);
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_onibus,null);
        }
        ImageView imageViewOnibus = (ImageView) view.findViewById(R.id.image_view_onibus);
        imageViewOnibus.setImageResource(R.drawable.ic_onibus);

        TextView textViewcodigoLinha = (TextView) view.findViewById(R.id.text_codigo_linha);
        textViewcodigoLinha.setText(onibus.getCodigoLinha());

        TextView textViewletreiroIda = (TextView) view.findViewById(R.id.text_letreiro_ida);
        textViewletreiroIda.setText(onibus.getLetreiroIda());

        TextView textViewletreiroVolta = (TextView) view.findViewById(R.id.text_letreiro_volta);
        textViewletreiroVolta.setText(onibus.getLetreiroVolta());

        TextView textViewprefixoLinha = (TextView) view.findViewById(R.id.text_prefixo_linha);
        textViewprefixoLinha.setText((String.valueOf(onibus.getPrefixoLinha())));

        return view;
    }


}
