package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by romain on 24/03/2018.
 */

public class BdSQLiteOpenHelper extends SQLiteOpenHelper{
    private static final int versionBD =1;
    private static final String  nomBD = "easyfood.db";

    private String requeteClient="create table Client(mailU TEXT PRIMARY KEY  , pseudoU TEXT, nomU TEXT, prenomU TEXT,numAdrU TEXT, nomAdrU TEXT, cpU TEXT, villeU TEXT, mdpU TEXT);";
    private String requeteClientDrop ="drop table if exists Client;";

    private String requeteRestaurateur="create table Restaurateur(mailU TEXT PRIMARY KEY  , pseudoU TEXT, nomU TEXT, prenomU TEXT,numAdrU TEXT, nomAdrU TEXT, cpU TEXT, villeU TEXT, mdpU TEXT);";
    private String requeteRestaurateurDrop ="drop table if exists Restaurateur;";

    private String requeteModerateur="create table Moderateur(mailU TEXT PRIMARY KEY  , pseudoU TEXT, nomU TEXT, prenomU TEXT,numAdrU TEXT, nomAdrU TEXT, cpU TEXT, villeU TEXT, mdpU TEXT);";
    private String requeteModerateurDrop ="drop table if exists Moderateur;";

    private String requeteResto ="create table Resto(idR INTEGER PRIMARY KEY , nomR TEXT, numAdrR INTEGER,rueAdrR TEXT, cpR INTEGER, villeR TEXT, idR INTEGER, mailU integer, FOREIGN KEY (mailU) REFERENCES Restaurateur(mailU));";
    private String requeteRestoDrop ="drop table if exists Resto;";

    private String requeteTypePlat ="create table TypePlat(idTP INTEGER PRIMARY KEY , libelleTP TEXT NOT NULL);";
    private String requeteTypePlatDrop ="drop table if exists TypePlat;";

    private String requetePlat ="create table Plat (idP INTEGER PRIMARY KEY , nomP TEXT NOT NULL, prixFournisseurP INTEGER, prixClientP INTEGER, platVisible BOOLEAN,photoP TEXT, descriptionP TEXT, FOREIGN KEY (idR) REFERENCES Resto(idR), FOREIGN KEY (idTP) REFERENCES TypePlat(idTP)));";
    private String requetePlatDrop ="drop table if exists Plat;";

    private String requeteCommande ="create table Commande(idC INTEGER PRIMARY KEY , dateC TEXT, commentaireClientC TEXT, dateLivrC TEXT, modeReglementC TEXT, mailU TEXT, FOREIGN KEY (mailU) REFERENCES Client(mailU));";
    private String requeteCommandeDrop ="drop table if exists Commande;";

    private String requeteContenir="create table Contenir(idP Integer, idC Integer, qtteComm, commentaire TEXT, commentaireVisible boolean,INTEGER, PRIMARY KEY(idP,idC), FOREIGN KEY(idP)REFERENCES Plat (idP), FOREIGN KEY(idC) REFERENCES Commande (idC));";
    private String requeteContenirDrop ="drop table if exists Contenir;";

    private String requeteEvaluer ="create table Evaluer(idR INTEGER, mailU TEXT,respectRecette DECIMAL, esthetiquePlat DECIMAL , cout INTEGER, qualiteNourriture Decimal, PRIMARY KEY(mailU, idR),FOREIGN KEY (mailU) REFERENCES Client(mailU), FOREIGN KEY (idR) REFERENCES Resto(idR));";
    private String requeteEvaluerDrop ="drop table if exists Evaluer;";


    public BdSQLiteOpenHelper(Context context){
        super(context, nomBD, null, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db ){
        db.execSQL(requeteClientDrop);
        db.execSQL(requeteRestaurateurDrop);
        db.execSQL(requeteModerateurDrop);
        db.execSQL(requeteRestoDrop);
        db.execSQL(requeteTypePlatDrop);
        db.execSQL(requetePlatDrop);
        db.execSQL(requeteCommandeDrop);
        db.execSQL(requeteContenirDrop);
        db.execSQL(requeteEvaluerDrop);

        db.execSQL(requeteCommande);
        db.execSQL("insert into Commande(idC , dateC , commentaireClientC , dateLivrC , modeReglementC , mailU )  values(1,'12/01/2018','Repas parfait','12/01/2018','Chèque','Client1@gmail.com');");
        db.execSQL("insert into Commande(idC , dateC , commentaireClientC , dateLivrC , modeReglementC , mailU )  values(2,'18/03/2018','Juste Passable','18/03/2018','Carte Bancaire','Client2@gmail.com');");
        db.execSQL("insert into Commande(idC , dateC , commentaireClientC , dateLivrC , modeReglementC , mailU )  values(3,'24/03/2018','Je ne recommande pas','24/03/2018','Especes','Client1@gmail.com');");


        db.execSQL(requeteClient);
        db.execSQL(requeteRestaurateur);
        db.execSQL(requeteModerateur);
        db.execSQL("insert into Client(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('Client1@gmail.com','Tyler','Durden','Tyler',5,'rue de la Paix',33000,'Bordeaux','test');");
        db.execSQL("insert into Client(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('Client2@gmail.com','Mario','Bros','Mario',14,'boulevard LaFaillette de la paix',24000,'Périgueux','test');");
        db.execSQL("insert into Restaurateur(mailU,pseudoU,nomU,prenomU,numAdrU,nomAdrU,cpU,villeU,mdpU)  values('Client12@gmail.com','Mario','Bros','Mario',14,'boulevard LaFaillette de la paix',24000,'Périgueux','test');");

        //db.execSQL(requeteResto);
//        db.execSQL(requeteTypePlat);
//        db.execSQL(requetePlat);

//        db.execSQL(requeteContenir);
//        db.execSQL(requeteEvaluer);
        Log.d("Test", "Passage dans onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.d("Test", "Passage dans onUpgrade");
        db.execSQL(requeteClientDrop);
        db.execSQL(requeteRestaurateurDrop);
        db.execSQL(requeteModerateurDrop);
        db.execSQL(requeteRestoDrop);
        db.execSQL(requeteTypePlatDrop);
        db.execSQL(requetePlatDrop);
        db.execSQL(requeteCommandeDrop);
        db.execSQL(requeteContenirDrop);
        db.execSQL(requeteEvaluerDrop);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("Test", "Passage dans onDowgrade");
        db.execSQL(requeteClientDrop);
        db.execSQL(requeteRestaurateurDrop);
        db.execSQL(requeteModerateurDrop);
        db.execSQL(requeteRestoDrop);
        db.execSQL(requeteTypePlatDrop);
        db.execSQL(requetePlatDrop);
        db.execSQL(requeteCommandeDrop);
        db.execSQL(requeteContenirDrop);
        db.execSQL(requeteEvaluerDrop);
        onCreate(db);
    }


}
