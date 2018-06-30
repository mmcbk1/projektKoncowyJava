import MainNav from './components/MainNav';
import Companies from './components/companies/Companies';
import Users from './components/users/Users';
import CompanyCreate from './components/companies/Create';

export const routes = [
    {path: '/companies', component:MainNav, children:[
            {path: '', name:'companies', component: Companies},
            {path: 'users', name:'users', component:Users},
            {path: 'create', name:'company-create', component:CompanyCreate},
        ]}
];