import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import ReactNotifications from 'react-notifications-component'
import './App.css';
import { LoginScreen,
				CadastrarQuestaoScreen,
				BuscarQuestaoScreen,
				CadastrarProvaScreen,
				VisualizarProvaScreen,
				ResolverProvaScreen,
				BuscarProvaParaCorrigirScreen,
				CorrigirProvaScreen,
				BuscarProvaJaCorrigidaScreen,
				ProvaPDFScreen,
				DashboardScreen } from './tela/index';
import { Header, Footer } from './component/index'

function App() {
	return (
		<>
		<ReactNotifications/>
			<BrowserRouter>
				<Switch>
					<Route path="/resolver-prova/:token" component={ResolverProvaScreen}/>
					<Route path="/login" component={LoginScreen} exact/>
					<div className="principal">
					<Header/>
					<Route path="/" component={DashboardScreen} exact/>
					<Route path="/cadastrar-questao" component={CadastrarQuestaoScreen}/>
					<Route path="/buscar-questao" component={BuscarQuestaoScreen}/>
					<Route path="/cadastrar-prova" component={CadastrarProvaScreen}/>
					<Route path="/visualizar-prova/:idProva" component={VisualizarProvaScreen}/>
					<Route path="/buscar-provas" component={BuscarProvaParaCorrigirScreen}/>
					<Route path="/corrigir-prova/:idProva" component={CorrigirProvaScreen}/>
					<Route path="/provas-corrigidas" component={BuscarProvaJaCorrigidaScreen}/>
					<Route path="/prova-PDF/:idProva" component={ProvaPDFScreen}/>
					<Footer/>
					</div>
				</Switch>
			</BrowserRouter>
		</>
	);
}

export default App;
