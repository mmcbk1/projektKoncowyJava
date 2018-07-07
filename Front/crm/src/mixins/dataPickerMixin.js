import moment from 'moment';
import Datepicker from 'vuejs-datepicker';

export const dataPickerMixin = {
    components: {
        'date-picker': Datepicker,
    },
    data() {
        return {

        }
    },
    methods: {
        customFormatter(date) {
            return moment(date).format('MM-DD-YYYY');
        }
    }
};