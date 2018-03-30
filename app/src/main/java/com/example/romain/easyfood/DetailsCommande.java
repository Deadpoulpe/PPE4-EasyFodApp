package com.example.romain.easyfood;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.romain.easyfood.DAO.CommandeDAO;
import com.example.romain.easyfood.DTO.Commande;
import com.example.romain.easyfood.DTO.Commandes;

import java.util.ArrayList;

public class DetailsCommande extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_commande);

        /**####################*/
        /**Declaration variable de connexion/arraylist/msgbox*/
        /**####################*/
        final CommandeDAO commandeAcess = new CommandeDAO(this);
        final Commandes lesCommandes = new Commandes();
        ArrayList<String> mesCommandes = new  ArrayList<String>();

        /**####################*/
        /**Récupération de l'id commande client envoyé depuis le ListeCommande*/
        /**####################*/
        Intent intent = getIntent();
        String monIdCom = intent.getStringExtra("maCommandeClient");

        /**####################*/
        /**On identifie grace à son id la commande selectionnée*/
        /**####################*/
        Cursor curseur = commandeAcess.getToutesLesCommandes();
        lesCommandes.setCommandes(curseur);
        Commande maCommande = lesCommandes.rechercheCommande(Integer.parseInt(monIdCom));

        /**####################*/
        /**On affecte et affiche les valeurs de la commande selectionnée */
        /**####################*/
        TextView numComm = (TextView) findViewById(R.id.numCom);
        numComm.setText(String.valueOf(maCommande.getIdC()));
        TextView dateComm = (TextView) findViewById(R.id.dateCommande);
        dateComm.setText(String.valueOf(maCommande.getDateC()));
        TextView dateLivr = (TextView) findViewById(R.id.dateLivrCommande);
        dateLivr.setText(String.valueOf(maCommande.getDateLivrC()));
        TextView comment = (TextView) findViewById(R.id.commentaireClient);
        comment.setText(String.valueOf(maCommande.getCommentaireClientC()));
        TextView modeRegl = (TextView) findViewById(R.id.modeReglement);
        modeRegl.setText(String.valueOf(maCommande.getModeReglementC()));
    }
}
