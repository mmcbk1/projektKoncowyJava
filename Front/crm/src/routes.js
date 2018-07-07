import MainNav from './components/MainNav';
import Companies from './components/companies/Companies';
import Company from './components/companies/Company';
import Users from './components/users/Users';
import CompanyCreate from './components/companies/Create';
import DepartmentCreate from './components/departments/Create';
import Department from './components/departments/Department';

export const routes = [
    {path: '/companies', component:MainNav, children:[
            {path: '', name:'companies', component: Companies},
            {path: ':cid', name:'company-single', component: Company},
            {path: ':cid/department/create', name:'department-create', component:DepartmentCreate},
            {path: ':cid/department/:did', name:'department-single', component:Department},
            {path: 'users', name:'users', component:Users},
            {path: 'create', name:'company-create', component:CompanyCreate},
        ]}
];