
const URI = 'http://localhost:8080/'

const ApiCalls = {

    signIn: (email, password, setId_val, setJwt) => {

        const credentials = {
            "email": email,
            "password": password
        }

        let id = 0;
        let token = ''

        fetch(URI + "user/authenticate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": 'application/json',
            },
            body: JSON.stringify(credentials)
        })
            .then(response => response.json())
            .then(data => {
                token = `Bearer ${data.jwt}`;
                id = data.id;
                if (id !== 0) {
                    if (token !== '' || token !== 'Bearer undefined') {
                        setId_val(id)
                        setJwt(token)
                    }
                }
            })
    },

    register: async (obj) => {
        let id = 0;
        let status = 0;

        await fetch(URI + 'user/register', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(obj)
        })
            .then(response => {
                status = response.status
                return response.json()
            })
            .then(data => {
                id = data.id
            });

        const acc = {
            "id": 0,
            "userId": id,
            "balance": 0
        }

        if (status === 201) {
            await fetch(URI + "checking/add-account", {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(acc)
            })
                .then(response => {
                    if (response.status === 201) {

                        const transaction = {
                            "id": 0,
                            "userId": id,
                            "type": "DEPOSIT_CHECKING",
                            "balance": 0,
                            "time": "0"
                        }

                        fetch(URI + "transaction/create", {
                            method: 'POST',
                            headers: {
                                "Content-Type": "application/json",
                            },
                            body: JSON.stringify(transaction)
                        })
                    }
                })

            await fetch(URI + "savings/add-account", {
                method: 'POST',
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(acc)
            })
                .then(response => {
                    if (response.status === 201) {

                        const transaction = {
                            "id": 0,
                            "userId": id,
                            "type": "DEPOSIT_SAVINGS",
                            "balance": 0,
                            "time": "0"
                        }

                        fetch(URI + "transaction/create", {
                            method: 'POST',
                            headers: {
                                "Content-Type": "application/json",
                            },
                            body: JSON.stringify(transaction)
                        })
                    }

                })


        }
    }
}

export default ApiCalls;