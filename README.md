# AdapterOnClickListener

- Make Adapter Class
```java
public class AdapterRv extends RecyclerView.Adapter<AdapterRv.MyHolder>{

    private OnItemClick click;

    public interface OnItemClick {
        void onItemClick(int position, String data);
    }

    public void setOnClickListener(OnItemClick onClick) {
        click = onClick;
    }
    
    private String[] data;

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
          holder.itemView.tv.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  click.onItemClick(position, data[position]);
              }
          });
    }
}
```

- Use Onclick
```java
public class MainActivity extends AppCompatActivity implements AdapterRv.OnItemClick{

    String[] data ={"M","Fadli","Zein"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ...
        
        AdapterRv adapterRv = new AdapterRv(this, data);
        adapterRv.setOnClickListener(MainActivity.this);

        recyclerView.setAdapter(adapterRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onItemClick(int position, String data) {
        Toast.makeText(this, "Position : " + position, Toast.LENGTH_SHORT).show();
    }
    
    ...
    
}
```

---

```
Copyright 2020 M. Fadli Zein
```
