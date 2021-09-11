package br.com.example.uaipay;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<Produto, List<String>> colecaoProdutos;
    private Map<Produto, List<String>> mobileCollection;
    //private Map<String, List<String>> mobileCollection;
    private List<Produto> groupList;
    //private List<Produto> listaProdutos;

    public MyExpandableListAdapter(Context context, List<Produto> groupList,
                                   Map<Produto, List<String>> mobileCollection){
        this.context = context;
        this.mobileCollection = mobileCollection;
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return mobileCollection.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mobileCollection.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mobileCollection.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //String mobileName = getGroup(groupPosition).toString();
        Produto produtoSelecionado =  (Produto)getGroup(groupPosition);
        String mobileName = produtoSelecionado.getNome();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.linha_produtos, null);
        }
        TextView item = convertView.findViewById(R.id.tvProduto);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(mobileName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String model = getChild(groupPosition, childPosition).toString();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_item, null);
        }
        TextView item = convertView.findViewById(R.id.tvModel);
        ImageView delete = convertView.findViewById(R.id.ivLixo);
        item.setText(model);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Você deseja excluir?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        List<String> child = mobileCollection.get(groupList.get(groupPosition));
                        child.remove(childPosition);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
