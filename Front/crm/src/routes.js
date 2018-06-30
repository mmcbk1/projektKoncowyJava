import Companies from './components/companies/Companies';
import Users from './components/users/Users';

export const routes = [
    {path: '/companies', name:'companies', component:Companies, children:[
            {path: 'users', name:'users', component:Users}
        ]}
];