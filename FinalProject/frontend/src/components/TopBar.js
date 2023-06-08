import React from 'react'
import logo from '../img/logo.jpg';
import { Link } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import {   logout } from '../redux/logSlice';
import { useSelector } from 'react-redux';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFileLines } from '@fortawesome/free-solid-svg-icons';

function TopBar() {
    
      
  

    const dispatch = useDispatch();
    const {isLoggedIn, username} = useSelector(store => ({
        isLoggedIn: store.log.isLoggedIn,
        username: store.log.username,
       

    }))

    
    const onClickLogout = () => {
        dispatch(logout());
    }


    

  

    let links = (
        <ul className="navbar-nav ">
            <li>
                <Link className="nav-link" to="/login" style={{ color: 'white', fontWeight: 'bold' }}>Giriş Yap</Link>
            </li>
            <li>
                <Link className="nav-link" to="/signup" style={{ color: 'white', fontWeight: 'bold' }}>Üye Ol</Link>
            </li>
          </ul>
    )

    if(isLoggedIn){
        links = (
            <ul className="navbar-nav ">
            <li>
                <Link className="nav-link" to={`/profile`} style={{ color: 'white', fontWeight: 'bold' }}>{username}</Link>
            </li>

            <li>
                <Link className="nav-link" to="/weathers"  style={{ color: 'white', fontWeight: 'bold' }}>Hava Durumları</Link>
            </li>
            
            <li>
                <Link className="nav-link" to="/" onClick={onClickLogout} style={{ color: 'white', fontWeight: 'bold' }}>Çıkış</Link>
            </li>
            
          </ul>
        )
    }




    return (
        /*
        <div className="shadow-sm bg-light mx-5  rounded " style={{ marginBottom: '70px' }} >
          <nav className="navbar navbar-light container navbar-expand">
            <div className="container-fluid">
              <Link className="navbar-brand" to="/">
              <img src={logo} alt="Logo" style={{ width: '180px', height: '50px',borderRadius: '48%' }} className="mr-2 " /> 
              </Link>
              {links}
            </div>
          </nav>
        </div> */
        <div>
        
        <div className="shadow-sm" style={{ backgroundColor: '#f4f4f4', padding: '8px 350px 8px 0', margin: '0 0 0 0' }}>
  {/* İkinci Navbar */}
  <nav className="navbar navbar-dark  navbar-expand" style={{ padding: '0', margin: '0 0 0 0' }}>
    <div className="container-fluid">
      <div className="navbar-collapse justify-content-end">
        <ul className="navbar-nav ">
          <li className="nav-item">
            <span className="nav-link" href="#" style={{ color: '#000' }}>Yatırımcı İlişkileri</span>
          </li>
          <li className="nav-item">
          <div style={{ display: 'flex', alignItems: 'center', marginLeft:"50px"}}>
         
            <FontAwesomeIcon icon={faFileLines} style={{color: "#333333"}} size="2xl" />
            <span className="nav-link" href="#" style={{ color: '#000' }}>Ürün ve Hizmet Ücretleri</span>
           </div>
           </li>
          <li className="nav-item">
            <span className="nav-link" href="#" style={{ color: '#000', marginLeft:"20px"}}>EN</span>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
</div>


        <div className="shadow-sm" style={{ marginBottom: '60px',marginTop:"0 0 0 0", backgroundColor: 'red', padding: '0 350px 0 0' }}>
          {/* Mevcut Navbar */}
          <nav className="navbar navbar-dark  navbar-expand" style={{ padding: '0 0 0 0',marginTop:"0 0 0 0" }}>
            <div className="container-fluid">
              <Link className="navbar-brand" to="/">
                <img src={logo} alt="Logo" style={{ width: '200px', height: '60px' ,marginLeft:"370px"}} className="mr-2" />
              </Link>
              {links}
            </div>
          </nav>
        </div>


        
      
      </div>
      

        
    )
  }






export default TopBar
