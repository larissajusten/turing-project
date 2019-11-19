import { store } from 'react-notifications-component'
import 'react-notifications-component/dist/theme.css'
import 'animate.css'

export const Notificacao = (titulo, mensagem, type) => {
  store.addNotification({
    title: titulo,
    message: mensagem,
    type: type,
    container: 'top-right',
    animationIn: ["animated", "fadeIn"],
    animationOut: ["animated", "fadeOut"],
    dismiss: {
      duration: 3000
    }
  })
}
