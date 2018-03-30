package com.example.romain.easyfood.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.romain.easyfood.DTO.Client;


/**
 * Created by romain on 24/03/2018.
 */

public class CommandeDAO {
    /**####################*/
    /**Declaration variable de connexion*/
    /**####################*/
    private BdSQLiteOpenHelper accesBD;

    public CommandeDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct);
    }

    /**####################*/
    /**On recupère toutes les commandes dans un curseur*/
    /**####################*/
    public Cursor getToutesLesCommandes(){
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        Cursor curseur = bd.rawQuery("SELECT * FROM COMMANDE", null);
        return curseur;
    }

    /**####################*/
    /**On recupère toutes les commandes d'un client dans un curseur*/
    /**####################*/
    public Cursor getLesCommandesClient(String idClient){
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        Cursor curseur = bd.rawQuery("SELECT * FROM COMMANDE WHERE mailU='"+idClient+"'", null);
        return curseur;
    }

    public Cursor getLesCommandesClientCursor(Client unClient){
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        String maRequete = "SELECT * FROM COMMANDE WHERE mailU ='"+unClient.getMailU()+"' ;";

        Cursor curseur = bd.rawQuery(maRequete, null);


        return curseur;

    }
    public Cursor getLesPlatsCommandesClient(String unIdCommande){
        SQLiteDatabase bd = accesBD.getReadableDatabase();
        String maRequete = "SELECT * FROM PLAT WHERE idC =? ;";
        Cursor curseur = bd.rawQuery(maRequete, new String[] {String.valueOf(unIdCommande)});
        return curseur;
    }


}
