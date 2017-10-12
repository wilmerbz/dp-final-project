package com.space.invaders.interfaces.mensajes;

public interface IColega {
	void setMediador(IMediador mediador);
	void recibirMensaje(String mensaje, Object data);
}