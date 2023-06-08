
import './App.css';
import { BrowserRouter, Route, Redirect, Switch} from 'react-router-dom';
import HomePage from './pages/HomePage';
import UserSignupPage from './pages/UserSignupPage';
import LoginPage from './pages/LoginPage';
import TopBar from './components/TopBar';
import ProfilePage from './pages/ProfilePage';
import SavedWeathers from './pages/SavedWeathers';
import Footer from './components/Footer';
import VerticalText from './components/VerticalText';



function App() {
  return (
    
      
      <BrowserRouter>
        <TopBar></TopBar>
        <Switch>

        <Route path="/" exact component={HomePage} />
        <Route path="/signup" exact component={UserSignupPage} />
        <Route path="/login" exact component={LoginPage} />
        <Route path="/profile" exact component={ProfilePage} />
        <Route path="/weathers" exact component={SavedWeathers} />
        <Redirect to="/" />
        </Switch>
        <VerticalText></VerticalText>
        <Footer></Footer>
      </BrowserRouter>
      
    
  );
}

export default App;
