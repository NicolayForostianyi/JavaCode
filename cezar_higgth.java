import java.util.Random;

public class cezar_higgth {
    String crypto_message;

    char[] hash;


    boolean check_el(int j){
        for(int i=0;i<hash.length;i++){
            if(hash[i]==(char)j){return false;}
        }
        return true;
    }

    private  void sleep(int num){
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void inizth_hash(){
        Random ran=new Random();
        hash=new char[10000];
        for(int i=0;i<10000;i++){
            if(i%100==0){
            show_process(i);}
            int num=ran.nextInt(10001);
            while(check_el(num)==false){
                num=ran.nextInt(10001);}
            hash[i]=(char) num;
        }
        System.out.println();

        }

    public static void clrscr(int l){
        for(int clear = 0; clear < l; clear++)
        {
            System.out.print("\b") ;
        }
    }
        void show_process(int i){
        clrscr(45);
        System.out.print("инициализация динамического алфавита ::"+i);
        sleep(50);
    }

    private int find_el(char el){
   for(int i=0;i<hash.length;i++){
        if(hash[i]==el){return i;}
   }
   return 0;
   }
    private String coder(String str,int key){
        char[] tmp= str.toCharArray();
        for(int i=0;i<tmp.length;i++){
            tmp[i]=(char)(find_el(tmp[i])+key);
        }

        String res=new String(tmp);
        System.out.println("закодированная строка::"+ res);
        return res;
    }


    cezar_higgth(String str, int key){
        inizth_hash();
        this.crypto_message=coder(str,key);
        System.out.println("сообщение закодированно экспортируете хеш и можете безопасно общаться ");
    }

    private String decoder(int key){
        System.out.println("вызвался метод с неипортированным хешем");
        System.out.print(" декодирую::: ");
        char[] tmp=crypto_message.toCharArray();
        for(int i=0;i<tmp.length;i++){
            tmp[i]=(char)((int)tmp[i]-key);
            tmp[i]=hash[(int)tmp[i]];
        }
        String str = new String(tmp);
        return str;
    }
    private String decoder(String mes,int key,char[] th_hash){
        System.out.println("вызвался метод со сторонними данными");
        char[] tmp=mes.toCharArray();
        for(int i=0;i<tmp.length;i++){
            tmp[i]=(char)((int)tmp[i]-key);
            tmp[i]=th_hash[(int)tmp[i]];
        }
        String res= new String(tmp);
        return res;
    }
    private String decoder(int key,char [] h){
        System.out.println("вызвался метод для разшировки внутреннего сообщения с испортом хеша и ключа");
        char[] tmp=crypto_message.toCharArray();
        for(int i=0;i<tmp.length;i++){
            tmp[i]=(char)((int)tmp[i]-key);
            tmp[i]=h[(int)tmp[i]];
        }
        String str=new String(tmp);
        return str;
    }
    public String get_message(int key){
        return decoder(key);
    }
    public String get_message(int key,char[] h){
        return decoder(key,h);
    }
    public String get_message(String mes , int key, char[] h){
        return decoder( mes, key,h);
    }
    public char[] export_hash(){
        System.out.println("Вызванна функция экспорта хеша, внутренний хеш уничтожен ");
        char tmp[]=this.hash.clone();
        for(int i=0;i<this.hash.length;i++){
            this.hash[i]=(char)0;
        }
        return tmp;
    }

    public String getCrypto_message(){
        return crypto_message;
    }
}
