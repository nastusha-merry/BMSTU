package ru.bmstu.nastasia.comparator;

public class BLOSUM { //BLOcks SUbstitution Matrix, матрица замен для аимнокислот

    public static CharComparator comparator = new CharComparator() {
        @Override
        public float compare(char a, char b) {
            return (float)M[idBlosum64(a)][idBlosum64(b)];
        };
    };

    public static final int[][] M = initBlosum();

//    Таблица штрафов за несовпадение нуклеотида
    public static int[][] initBlosum() {
        int[][] blosumM = new int[24][24];
        for (int  i= 0; i < 24; ++i) {
            blosumM[0][i] = blosumM[i][0] = -4;
        }
        blosumM[1][1]= 4;
        blosumM[1][2]=-1;
        blosumM[1][3]=-2;
        blosumM[1][4]=-2;
        blosumM[1][5]=0;
        blosumM[1][6]=-1;
        blosumM[1][7]=-1;
        blosumM[1][8]=0;
        blosumM[1][9]=-2;
        blosumM[1][10]=-1;
        blosumM[1][11]=-1;
        blosumM[1][12]=-1;
        blosumM[1][13]=-1;
        blosumM[1][14]=-2;
        blosumM[1][15]=-1;
        blosumM[1][16]=1;
        blosumM[1][17]=0;
        blosumM[1][18]=-3;
        blosumM[1][19]=-2;
        blosumM[1][20]=0;
        blosumM[1][21]=-2;
        blosumM[1][22]=-1;
        blosumM[1][23]=0;
        blosumM[2][1]=-1;
        blosumM[2][2]=5;
        blosumM[2][3]=0;
        blosumM[2][4]=-2;
        blosumM[2][5]=-3;
        blosumM[2][6]=1;
        blosumM[2][7]=0;
        blosumM[2][8]=-2;
        blosumM[2][9]=0;
        blosumM[2][10]=-3;
        blosumM[2][11]=-2;
        blosumM[2][12]=2;
        blosumM[2][13]=-1;
        blosumM[2][14]=-3;
        blosumM[2][15]=-2;
        blosumM[2][16]=-1;
        blosumM[2][17]=-1;
        blosumM[2][18]=-3;
        blosumM[2][19]=-2;
        blosumM[2][20]=-3;
        blosumM[2][21]=-1;
        blosumM[2][22]=0;
        blosumM[2][23]=-1;
        blosumM[3][1]=-2;
        blosumM[3][2]=0;
        blosumM[3][3]=6;
        blosumM[3][4]=1;
        blosumM[3][5]=-3;
        blosumM[3][6]=0;
        blosumM[3][7]=0;
        blosumM[3][8]=0;
        blosumM[3][9]=1;
        blosumM[3][10]=-3;
        blosumM[3][11]=-3;
        blosumM[3][12]=0;
        blosumM[3][13]=-2;
        blosumM[3][14]=-3;
        blosumM[3][15]=-2;
        blosumM[3][16]=1;
        blosumM[3][17]=0;
        blosumM[3][18]=-4;
        blosumM[3][19]=-2;
        blosumM[3][20]=-3;
        blosumM[3][21]=3;
        blosumM[3][22]=0;
        blosumM[3][23]=-1;
        blosumM[4][1]=-2;
        blosumM[4][2]=-2;
        blosumM[4][3]=1;
        blosumM[4][4]=6;
        blosumM[4][5]=-3;
        blosumM[4][6]=0;
        blosumM[4][7]=2;
        blosumM[4][8]=-1;
        blosumM[4][9]=-1;
        blosumM[4][10]=-3;
        blosumM[4][11]=-4;
        blosumM[4][12]=-1;
        blosumM[4][13]=-3;
        blosumM[4][14]=-3;
        blosumM[4][15]=-1;
        blosumM[4][16]=0;
        blosumM[4][17]=-1;
        blosumM[4][18]=-4;
        blosumM[4][19]=-3;
        blosumM[4][20]=-3;
        blosumM[4][21]=4;
        blosumM[4][22]=1;
        blosumM[4][23]=-1;
        blosumM[5][1]=0;
        blosumM[5][2]=-3;
        blosumM[5][3]=-3;
        blosumM[5][4]=-3;
        blosumM[5][5]=9;
        blosumM[5][6]=-3;
        blosumM[5][7]=-4;
        blosumM[5][8]=-3;
        blosumM[5][9]=-3;
        blosumM[5][10]=-1;
        blosumM[5][11]=-1;
        blosumM[5][12]=-3;
        blosumM[5][13]=-1;
        blosumM[5][14]=-2;
        blosumM[5][15]=-3;
        blosumM[5][16]=-1;
        blosumM[5][17]=-1;
        blosumM[5][18]=-2;
        blosumM[5][19]=-2;
        blosumM[5][20]=-1;
        blosumM[5][21]=-3;
        blosumM[5][22]=-3;
        blosumM[5][23]=-2;
        blosumM[6][1]=-1;
        blosumM[6][2]=1;
        blosumM[6][3]=0;
        blosumM[6][4]=0;
        blosumM[6][5]=-3;
        blosumM[6][6]=5;
        blosumM[6][7]=2;
        blosumM[6][8]=-2;
        blosumM[6][9]=0;
        blosumM[6][10]=-3;
        blosumM[6][11]=-2;
        blosumM[6][12]=1;
        blosumM[6][13]=0;
        blosumM[6][14]=-3;
        blosumM[6][15]=-1;
        blosumM[6][16]=0;
        blosumM[6][17]=-1;
        blosumM[6][18]=-2;
        blosumM[6][19]=-1;
        blosumM[6][20]=-2;
        blosumM[6][21]=0;
        blosumM[6][22]=3;
        blosumM[6][23]=-1;
        blosumM[7][1]=-1;
        blosumM[7][2]=0;
        blosumM[7][3]=0;
        blosumM[7][4]=2;
        blosumM[7][5]=-4;
        blosumM[7][6]=2;
        blosumM[7][7]=5;
        blosumM[7][8]=-2;
        blosumM[7][9]=0;
        blosumM[7][10]=-3;
        blosumM[7][11]=-3;
        blosumM[7][12]=1;
        blosumM[7][13]=-2;
        blosumM[7][14]=-3;
        blosumM[7][15]=-1;
        blosumM[7][16]=0;
        blosumM[7][17]=-1;
        blosumM[7][18]=-3;
        blosumM[7][19]=-2;
        blosumM[7][20]=-2;
        blosumM[7][21]=1;
        blosumM[7][22]=4;
        blosumM[7][23]=-1;
        blosumM[8][1]=0;
        blosumM[8][2]=-2;
        blosumM[8][3]=0;
        blosumM[8][4]=-1;
        blosumM[8][5]=-3;
        blosumM[8][6]=-2;
        blosumM[8][7]=-2;
        blosumM[8][8]=6;
        blosumM[8][9]=-2;
        blosumM[8][10]=-4;
        blosumM[8][11]=-4;
        blosumM[8][12]=-2;
        blosumM[8][13]=-3;
        blosumM[8][14]=-3;
        blosumM[8][15]=-2;
        blosumM[8][16]=0;
        blosumM[8][17]=-2;
        blosumM[8][18]=-2;
        blosumM[8][19]=-3;
        blosumM[8][20]=-3;
        blosumM[8][21]=-1;
        blosumM[8][22]=-2;
        blosumM[8][23]=-1;
        blosumM[9][1]=-2;
        blosumM[9][2]=0;
        blosumM[9][3]=1;
        blosumM[9][4]=-1;
        blosumM[9][5]=-3;
        blosumM[9][6]=0;
        blosumM[9][7]=0;
        blosumM[9][8]=-2;
        blosumM[9][9]=8;
        blosumM[9][10]=-3;
        blosumM[9][11]=-3;
        blosumM[9][12]=-1;
        blosumM[9][13]=-2;
        blosumM[9][14]=-1;
        blosumM[9][15]=-2;
        blosumM[9][16]=-1;
        blosumM[9][17]=-2;
        blosumM[9][18]=-2;
        blosumM[9][19]=2;
        blosumM[9][20]=-3;
        blosumM[9][21]=0;
        blosumM[9][22]=0;
        blosumM[9][23]=-1;
        blosumM[10][1]=-1;
        blosumM[10][2]=-3;
        blosumM[10][3]=-3;
        blosumM[10][4]=-3;
        blosumM[10][5]=-1;
        blosumM[10][6]=-3;
        blosumM[10][7]=-3;
        blosumM[10][8]=-4;
        blosumM[10][9]=-3;
        blosumM[10][10]=4;
        blosumM[10][11]=2;
        blosumM[10][12]=-3;
        blosumM[10][13]=1;
        blosumM[10][14]=0;
        blosumM[10][15]=-3;
        blosumM[10][16]=-2;
        blosumM[10][17]=-1;
        blosumM[10][18]=-3;
        blosumM[10][19]=-1;
        blosumM[10][20]=3;
        blosumM[10][21]=-3;
        blosumM[10][22]=-3;
        blosumM[10][23]=-1;
        blosumM[11][1]=-1;
        blosumM[11][2]=-2;
        blosumM[11][3]=-3;
        blosumM[11][4]=-4;
        blosumM[11][5]=-1;
        blosumM[11][6]=-2;
        blosumM[11][7]=-3;
        blosumM[11][8]=-4;
        blosumM[11][9]=-3;
        blosumM[11][10]=2;
        blosumM[11][11]=4;
        blosumM[11][12]=-2;
        blosumM[11][13]=2;
        blosumM[11][14]=0;
        blosumM[11][15]=-3;
        blosumM[11][16]=-2;
        blosumM[11][17]=-1;
        blosumM[11][18]=-2;
        blosumM[11][19]=-1;
        blosumM[11][20]=1;
        blosumM[11][21]=-4;
        blosumM[11][22]=-3;
        blosumM[11][23]=-1;
        blosumM[12][1]=-1;
        blosumM[12][2]=2;
        blosumM[12][3]=0;
        blosumM[12][4]=-1;
        blosumM[12][5]=-3;
        blosumM[12][6]=1;
        blosumM[12][7]=1;
        blosumM[12][8]=-2;
        blosumM[12][9]=-1;
        blosumM[12][10]=-3;
        blosumM[12][11]=-2;
        blosumM[12][12]=5;
        blosumM[12][13]=-1;
        blosumM[12][14]=-3;
        blosumM[12][15]=-1;
        blosumM[12][16]=0;
        blosumM[12][17]=-1;
        blosumM[12][18]=-3;
        blosumM[12][19]=-2;
        blosumM[12][20]=-2;
        blosumM[12][21]=0;
        blosumM[12][22]=1;
        blosumM[12][23]=-1;
        blosumM[13][1]=-1;
        blosumM[13][2]=-1;
        blosumM[13][3]=-2;
        blosumM[13][4]=-3;
        blosumM[13][5]=-1;
        blosumM[13][6]=0;
        blosumM[13][7]=-2;
        blosumM[13][8]=-3;
        blosumM[13][9]=-2;
        blosumM[13][10]=1;
        blosumM[13][11]=2;
        blosumM[13][12]=-1;
        blosumM[13][13]=5;
        blosumM[13][14]=0;
        blosumM[13][15]=-2;
        blosumM[13][16]=-1;
        blosumM[13][17]=-1;
        blosumM[13][18]=-1;
        blosumM[13][19]=-1;
        blosumM[13][20]=1;
        blosumM[13][21]=-3;
        blosumM[13][22]=-1;
        blosumM[13][23]=-1;
        blosumM[14][1]=-2;
        blosumM[14][2]=-3;
        blosumM[14][3]=-3;
        blosumM[14][4]=-3;
        blosumM[14][5]=-2;
        blosumM[14][6]=-3;
        blosumM[14][7]=-3;
        blosumM[14][8]=-3;
        blosumM[14][9]=-1;
        blosumM[14][10]=0;
        blosumM[14][11]=0;
        blosumM[14][12]=-3;
        blosumM[14][13]=0;
        blosumM[14][14]=6;
        blosumM[14][15]=-4;
        blosumM[14][16]=-2;
        blosumM[14][17]=-2;
        blosumM[14][18]=1;
        blosumM[14][19]=3;
        blosumM[14][20]=-1;
        blosumM[14][21]=-3;
        blosumM[14][22]=-3;
        blosumM[14][23]=-1;
        blosumM[15][1]=-1;
        blosumM[15][2]=-2;
        blosumM[15][3]=-2;
        blosumM[15][4]=-1;
        blosumM[15][5]=-3;
        blosumM[15][6]=-1;
        blosumM[15][7]=-1;
        blosumM[15][8]=-2;
        blosumM[15][9]=-2;
        blosumM[15][10]=-3;
        blosumM[15][11]=-3;
        blosumM[15][12]=-1;
        blosumM[15][13]=-2;
        blosumM[15][14]=-4;
        blosumM[15][15]=7;
        blosumM[15][16]=-1;
        blosumM[15][17]=-1;
        blosumM[15][18]=-4;
        blosumM[15][19]=-3;
        blosumM[15][20]=-2;
        blosumM[15][21]=-2;
        blosumM[15][22]=-1;
        blosumM[15][23]=-2;
        blosumM[16][1]=1;
        blosumM[16][2]=-1;
        blosumM[16][3]=1;
        blosumM[16][4]=0;
        blosumM[16][5]=-1;
        blosumM[16][6]=0;
        blosumM[16][7]=0;
        blosumM[16][8]=0;
        blosumM[16][9]=-1;
        blosumM[16][10]=-2;
        blosumM[16][11]=-2;
        blosumM[16][12]=0;
        blosumM[16][13]=-1;
        blosumM[16][14]=-2;
        blosumM[16][15]=-1;
        blosumM[16][16]=4;
        blosumM[16][17]=1;
        blosumM[16][18]=-3;
        blosumM[16][19]=-2;
        blosumM[16][20]=-2;
        blosumM[16][21]=0;
        blosumM[16][22]=0;
        blosumM[16][23]=0;
        blosumM[17][1]=0;
        blosumM[17][2]=-1;
        blosumM[17][3]=0;
        blosumM[17][4]=-1;
        blosumM[17][5]=-1;
        blosumM[17][6]=-1;
        blosumM[17][7]=-1;
        blosumM[17][8]=-2;
        blosumM[17][9]=-2;
        blosumM[17][10]=-1;
        blosumM[17][11]=-1;
        blosumM[17][12]=-1;
        blosumM[17][13]=-1;
        blosumM[17][14]=-2;
        blosumM[17][15]=-1;
        blosumM[17][16]=1;
        blosumM[17][17]=5;
        blosumM[17][18]=-2;
        blosumM[17][19]=-2;
        blosumM[17][20]=0;
        blosumM[17][21]=-1;
        blosumM[17][22]=-1;
        blosumM[17][23]=0;
        blosumM[18][1]=-3;
        blosumM[18][2]=-3;
        blosumM[18][3]=-4;
        blosumM[18][4]=-4;
        blosumM[18][5]=-2;
        blosumM[18][6]=-2;
        blosumM[18][7]=-3;
        blosumM[18][8]=-2;
        blosumM[18][9]=-2;
        blosumM[18][10]=-3;
        blosumM[18][11]=-2;
        blosumM[18][12]=-3;
        blosumM[18][13]=-1;
        blosumM[18][14]=1;
        blosumM[18][15]=-4;
        blosumM[18][16]=-3;
        blosumM[18][17]=-2;
        blosumM[18][18]=11;
        blosumM[18][19]=2;
        blosumM[18][20]=-3;
        blosumM[18][21]=-4;
        blosumM[18][22]=-3;
        blosumM[18][23]=-2;
        blosumM[19][1]=-2;
        blosumM[19][2]=-2;
        blosumM[19][3]=-2;
        blosumM[19][4]=-3;
        blosumM[19][5]=-2;
        blosumM[19][6]=-1;
        blosumM[19][7]=-2;
        blosumM[19][8]=-3;
        blosumM[19][9]=2;
        blosumM[19][10]=-1;
        blosumM[19][11]=-1;
        blosumM[19][12]=-2;
        blosumM[19][13]=-1;
        blosumM[19][14]=3;
        blosumM[19][15]=-3;
        blosumM[19][16]=-2;
        blosumM[19][17]=-2;
        blosumM[19][18]=2;
        blosumM[19][19]=7;
        blosumM[19][20]=-1;
        blosumM[19][21]=-3;
        blosumM[19][22]=-2;
        blosumM[19][23]=-1;
        blosumM[20][1]=0;
        blosumM[20][2]=-3;
        blosumM[20][3]=-3;
        blosumM[20][4]=-3;
        blosumM[20][5]=-1;
        blosumM[20][6]=-2;
        blosumM[20][7]=-2;
        blosumM[20][8]=-3;
        blosumM[20][9]=-3;
        blosumM[20][10]=3;
        blosumM[20][11]=1;
        blosumM[20][12]=-2;
        blosumM[20][13]=1;
        blosumM[20][14]=-1;
        blosumM[20][15]=-2;
        blosumM[20][16]=-2;
        blosumM[20][17]=0;
        blosumM[20][18]=-3;
        blosumM[20][19]=-1;
        blosumM[20][20]=4;
        blosumM[20][21]=-3;
        blosumM[20][22]=-2;
        blosumM[20][23]=-1;
        blosumM[21][1]=-2;
        blosumM[21][2]=-1;
        blosumM[21][3]=3;
        blosumM[21][4]=4;
        blosumM[21][5]=-3;
        blosumM[21][6]=0;
        blosumM[21][7]=1;
        blosumM[21][8]=-1;
        blosumM[21][9]=0;
        blosumM[21][10]=-3;
        blosumM[21][11]=-4;
        blosumM[21][12]=0;
        blosumM[21][13]=-3;
        blosumM[21][14]=-3;
        blosumM[21][15]=-2;
        blosumM[21][16]=0;
        blosumM[21][17]=-1;
        blosumM[21][18]=-4;
        blosumM[21][19]=-3;
        blosumM[21][20]=-3;
        blosumM[21][21]=4;
        blosumM[21][22]=1;
        blosumM[21][23]=-1;
        blosumM[22][1]=-1;
        blosumM[22][2]=0;
        blosumM[22][3]=0;
        blosumM[22][4]=1;
        blosumM[22][5]=-3;
        blosumM[22][6]=3;
        blosumM[22][7]=4;
        blosumM[22][8]=-2;
        blosumM[22][9]=0;
        blosumM[22][10]=-3;
        blosumM[22][11]=-3;
        blosumM[22][12]=1;
        blosumM[22][13]=-1;
        blosumM[22][14]=-3;
        blosumM[22][15]=-1;
        blosumM[22][16]=0;
        blosumM[22][17]=-1;
        blosumM[22][18]=-3;
        blosumM[22][19]=-2;
        blosumM[22][20]=-2;
        blosumM[22][21]=1;
        blosumM[22][22]=4;
        blosumM[22][23]=-1;
        blosumM[23][1]=0;
        blosumM[23][2]=-1;
        blosumM[23][3]=-1;
        blosumM[23][4]=-1;
        blosumM[23][5]=-2;
        blosumM[23][6]=-1;
        blosumM[23][7]=-1;
        blosumM[23][8]=-1;
        blosumM[23][9]=-1;
        blosumM[23][10]=-1;
        blosumM[23][11]=-1;
        blosumM[23][12]=-1;
        blosumM[23][13]=-1;
        blosumM[23][14]=-1;
        blosumM[23][15]=-2;
        blosumM[23][16]=0;
        blosumM[23][17]=0;
        blosumM[23][18]=-2;
        blosumM[23][19]=-1;
        blosumM[23][20]=-1;
        blosumM[23][21]=-1;
        blosumM[23][22]=-1;
        blosumM[23][23]=-1;
        return blosumM;
    }

    // Номер строки/столбца, соответствующего нуклеотиду
    public static int idBlosum64(char a) {
        switch(a) {
            case 'A': return 1;
            case 'R': return 2;
            case 'N': return 3;
            case 'D': return 4;
            case 'C': return 5;
            case 'Q': return 6;
            case 'E': return 7;
            case 'G': return 8;
            case 'H': return 9;
            case 'I': return 10;
            case 'L': return 11;
            case 'K': return 12;
            case 'M': return 13;
            case 'F': return 14;
            case 'P': return 15;
            case 'S': return 16;
            case 'T': return 17;
            case 'W': return 18;
            case 'Y': return 19;
            case 'V': return 20;
            case 'B': return 21;
            case 'Z': return 22;
            case 'X': return 23;
        }
        return 0;
    }
}