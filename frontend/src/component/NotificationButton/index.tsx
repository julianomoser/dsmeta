import axios from 'axios';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';

import './styles.css';

type Props = {
    saleId: number;
}

function handleClich(saleId: number) {
    axios(`${BASE_URL}/sales/saleId/notification`)
    .then(response => {
      console.log("SUCESSO");
    });
}

function NotificationButton( {saleId} : Props) {
  return (
    <div className="dsmeta-red-btn" onClick={() => handleClich(saleId)}>
      <img src={icon} alt="Notificar" />
    </div>
  )
}

export default NotificationButton;
