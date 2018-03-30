package com.example.romain.easyfood.DTO;

public class Contenir {
	private Plat plat ;
	private Commande commande ;
	private Integer qteComm ;
	private String commentaire;
	private String commentaireVisible;
	
	public Contenir (Plat pplat, Commande  pcommande, Integer pqteComm, String pcommentaire, String pcommentaireVisible) {
		this.setplat(pplat);
		this.setcommande(pcommande);
		this.setQteComm(pqteComm);
		this.setCommentaire(pcommentaire);
		this.setCommentaireVisible(pcommentaireVisible);
	}

	public Plat getplat() {
		return plat;
	}

	public void setplat(Plat plat) {
		this.plat = plat;
	}

	public Commande getcommande() {
		return commande;
	}

	public void setcommande(Commande commande) {
		this.commande = commande;
	}

	public Integer getQteComm() {
		return qteComm;
	}

	public void setQteComm(Integer qteComm) {
		this.qteComm = qteComm;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getCommentaireVisible() {
		return commentaireVisible;
	}

	public void setCommentaireVisible(String commentaireVisible) {
		this.commentaireVisible = commentaireVisible;
	}
	
}
