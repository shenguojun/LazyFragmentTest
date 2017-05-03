# LazyFragmentTest
Fragment may contain lots of heavy loading work, which will lead to slow loading in some cases.Using lazy loading can postpone the view initialization work to the time when activity get user focus. In this project, we try to implement Fragment lazy loading in two difference way.

The first way is using Inheritance. We use `InheritedFakeFragment` as base Fragment and the lazy load Fragment should override `onLazyCreateView` and `onLazyViewCreated` to replace `onCreateView` and `onViewCreated`. The lazy method will be called after base Fragment got user focus.

The second way is using Proxy. We create a proxy fragment `ProxyFakeFragment` and use it as a proxy to create the real Fragment.

## Using `InheritedFakeFragment` example:

We need to change to `OriginFragment` to `InheritedLazyFragment` by changing `onCreateView` and `onViewCreated`. 

```java
public class InheritedLazyFragment extends InheritedFakeFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFragmentMsg = getArguments().getString(FRAGMENT_MSG);
            mPos = getArguments().getInt(FRAGMENT_POS);
        }
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onCreate");
    }

    @Override
    public View onLazyCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_origin, container, false);
        TextView content = (TextView) view.findViewById(R.id.FragmentContent);
        content.setText(mFragmentMsg + mPos);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onLazyCreateView");
        return view;
    }
}
```
Fragment creation is the same as `OriginFragment` : `return InheritedLazyFragment.newInstance("InheritedLazyFragment", position);`.

## Using `ProxyFakeFragment` example:

The `OriginFragment` don't need to change and the creation process need to use proxy as :
```java
Bundle bundle = new Bundle();
bundle.putString(InheritedLazyFragment.FRAGMENT_MSG, "ProxyLazyFragment");
bundle.putInt(InheritedLazyFragment.FRAGMENT_POS, position);
return ProxyFakeFragment.newInstance(OriginFragment.class.getName(), bundle);
```