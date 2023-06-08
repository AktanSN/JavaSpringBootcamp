import React, { useState } from 'react';
import akbankgif from '../img/akbankgif.gif';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeadset,faLocationDot,faQuestion,faUnlockKeyhole } from '@fortawesome/free-solid-svg-icons';
import { useSelector } from "react-redux";

const Footer = () => {
    const { username } = useSelector((store) => store.log);

    const [isOpen, setIsOpen] = useState(false);

  const handleIconClick = () => {
    setIsOpen(!isOpen);
  };
  return (
    <footer style={{ backgroundColor: '#363636', color: '#fff', padding: '20px', textAlign: 'center', position: 'fixed', bottom: 0, left: 0, right: 0 }}>
    
    <div style={{ display: 'flex', justifyContent: 'center', marginBottom: '10px' }}>
        <div style={{ display: 'flex', alignItems: 'center', marginRight: '20px' }}>
          <FontAwesomeIcon icon={faHeadset} size="2xl" style={{color: "#ff0000",marginRight:"8px"}} />
          <span style={{ fontWeight: 'bold', fontSize: '18px' ,fontFamily:"revert-layer" }}>DESTEK MERKEZİ</span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', marginRight: '20px' }}>
          <div style={{ width: '1px', height: '20px', backgroundColor: '#fff', marginRight: '10px' }}></div>
          <FontAwesomeIcon icon={faLocationDot} size="2xl" style={{color: "#ff0000",marginRight:"8px",marginLeft:"8px"}} />
          <span style={{ fontWeight: 'bold', fontSize: '18px' ,fontFamily:"revert-layer" }}>ATM VE ŞUBELERİMİZ</span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center', marginRight: '20px' }}>
          <div style={{ width: '1px', height: '20px', backgroundColor: '#fff', marginRight: '10px' }}></div>
          <FontAwesomeIcon icon={faQuestion} size="2xl" style={{color: "#ff0000",marginRight:"8px",marginLeft:"8px"}} />
          <span style={{ fontWeight: 'bold', fontSize: '18px' ,fontFamily:"revert-layer" }}>BAŞVURUM NEREDE</span>
        </div>
        <div style={{ display: 'flex', alignItems: 'center' }}>
          <div style={{ width: '1px', height: '20px', backgroundColor: '#fff', marginRight: '10px' }}></div>
          <FontAwesomeIcon icon={faUnlockKeyhole} size="2xl"style={{color: "#ff0000",marginRight:"8px",marginLeft:"8px"}}/>
          <span style={{ fontWeight: 'bold', fontSize: '18px' ,fontFamily:"revert-layer" }}>GÜVENLİĞİNİZ İÇİN</span>
        </div>
        
      </div>
      {
        username && (
            <div id="_sorun_icon"  onClick={handleIconClick} style={{ display: 'block', position: 'fixed', right: 0, bottom: 0, cursor: 'pointer', zIndex: 999999, width: '260px', height: '225px' }}>
            <img src={akbankgif} alt="GIF" style={{ width: '220px', height: '220px' }} />

        </div>
        )
      }
        
        
        {isOpen && (
            <div style={{ position: 'fixed', right: '80px',width:"355px",height:"300px", bottom: '190px', backgroundColor: '#fff', padding: '10px' ,borderRadius:"50px"}}>
                <div className="container">
                    <h5 style={{ color:"red", marginBottom:"30px"}}>Selam, ben Aktan!</h5>
                    <p style={{ color:"black" }}>Bu alan henüz geliştirme aşamasındadır.</p>
                    <p style={{ color:"black" }}>Bana ulaşmak için <a href="https://www.linkedin.com/in/ibrahim-aktan-sanhal/" >Linkedin</a> adresimi ziyaret edebilir veya mail atabilirsiniz</p>
                    <p style={{ color:"black" }}>Mail adresim: <span style={{ color:"red" , fontWeight:"bold"}}> aktansanhal@gmail.com </span></p>
                    <p style={{ color:"black" }}>İyi günler dilerim.</p>
                </div>  
            </div>
          )}
    </footer>
  );
};

export default Footer;
