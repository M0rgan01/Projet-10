package com.bibliotheque.metier;

import java.util.List;

import com.bibliotheque.entities.Kind;
import com.bibliotheque.exception.BibliothequeException;

public interface KindBusiness {

	public void saveKind(Kind kind);
	public List<Kind> getListKind();
	public Kind getKind(String name);
	public void validateKind(Kind kind) throws BibliothequeException;
}
