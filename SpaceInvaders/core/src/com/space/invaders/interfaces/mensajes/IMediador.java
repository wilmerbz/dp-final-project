package com.space.invaders.interfaces.mensajes;

public interface IMediador {
	void registrarColega(IColega colega);
	void desregistrarColega(IColega colega);
	void enviarMensaje(IColega sender, String mensaje, Object data);
}