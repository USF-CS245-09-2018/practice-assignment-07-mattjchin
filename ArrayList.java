package Lesson7;

public class ArrayList implements List{

    public static final int DEFAULT_ARR_LIST_SIZE = 10;
    public Object[] arrayList = new Object[DEFAULT_ARR_LIST_SIZE];
    private int size = 0;

    @Override
    public void add(Object obj) {
        if(size>=arrayList.length)
            doubleListSize();
        arrayList[size] = obj;
        size++;
    }

    @Override
    public void add(int pos, Object obj) {

        if(arrayList.length <= pos)
            doubleListSize();
        if(pos<0)
            throw new IndexOutOfBoundsException();
        for(int i=size; i>pos; i--)
            arrayList[i] = arrayList[i-1];
        arrayList[pos] = obj;
        size++;
    }

    @Override
    public Object get(int pos) {
        if(pos>=arrayList.length)
            throw new IndexOutOfBoundsException();
//        for(int x=size; x<arrayList.length; x++){
//            if(arrayList[x] != arrayList[pos]) {
////                pos = x;
////                break;
//                size++;
//            }
//            else{
//                pos = size;
//                break;
//            }
//        }
        return arrayList[pos];
    }

    @Override
    public Object remove(int pos) {
        Object temp_index = arrayList[pos];
        if(pos>=arrayList.length)
            throw new IndexOutOfBoundsException();
        for(int i=pos; i<arrayList.length-1; i++)
            arrayList[i] = arrayList[i+1];
        size--;
        return temp_index;
    }

    @Override
    public int size() {
        if(size==0)
            return 0;
        return size;
    }

    public void doubleListSize(){

        Object[] temp_arrList = new Object[arrayList.length * 2];
//        this.size = 0;
        for(int i=0; i<arrayList.length; i++)
            temp_arrList[i] = arrayList[i];
        arrayList = temp_arrList;
    }
}
