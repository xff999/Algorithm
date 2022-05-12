package Other;

import java.util.Arrays;

public class c_dfs_数独游戏{
    public static void main(String[] args) {
          char[][] table= {
                  {'0','0','5','3','0','0','0','0','0'},
                  {'8','0','0','0','0','0','0','2','0'},
                  {'0','7','0','0','1','0','5','0','0'},
                  {'4','0','0','0','0','5','3','0','0'},
                  {'0','1','0','0','7','0','0','0','6'},
                  {'0','0','3','2','0','0','0','8','0'},
                  {'0','6','0','5','0','0','0','0','9'},
                  {'0','0','4','0','0','0','0','3','0'},
                  {'0','0','0','0','0','9','7','0','0'}};
           dfs(table, 0,0);

    }

    public static void dfs(char[][] table ,int x,int y){
        if(x==9){//判断结束的情况
            print(table);
            System.exit(0); //直接退出
        }
        //判断这个坐标的值，是否被填写
        if(table[x][y] == '0'){  //没有被填写
            //1--9 遍历要能够填入哪一个符合
            for (int k = 1; k <10 ; k++) {
                if(check(table,x,y,k)){  //先判断填入k 是否满足
                 table[x][y]=(char)('0'+k); //满足 则填入 k 的值
                  // dfs 的方式，判断下一个的值
                  dfs(table,x+(y+1)/9,(y+1)%9);  //这里的处理方式
               }
            }
            //如果上面的不满足，一定要回溯，
            table[x][y]='0';  //重新赋值为0 表示没访问成功
        }else {
            //这个坐标被访问了，则访问下一个
            dfs(table,x+(y+1)/9,(y+1)%9);
        }

    }

    public static boolean check(char[][] table,int x,int y,int k){
           //检查同行同列
        for (int i = 0; i < 9; i++) {
            if(table[x][i]==(char)(k+'0')) return false;
            if(table[i][y]==(char)(k+'0')) return false;
            }
        //检查 小的 9宫格
        for (int i = (x/3)*3; i <(x/3+1)*3 ; i++) {
            for (int j = (y/3)*3; j <(y/3+1)*3 ; j++) {
                if(table[i][j]==(char)(k+'0'))return false;
            }
        }
        return true;
        }



    public static void print(char[][] table){
        for (int i = 0; i <table.length ; i++) {
            System.out.println(Arrays.toString(table[i]));
        }
    }

}
