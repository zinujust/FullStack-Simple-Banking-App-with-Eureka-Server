import { createSlice, } from "@reduxjs/toolkit";

const initialState = {
    token: '',
    id: 0,
    isAuthenticated: false
}

const userSlice = createSlice({
    name: 'userLogin',
    initialState,
    reducers: {
        setToken: (state, action) => {
            state.token = action.payload;
        },

        unsetToken: (state) => {
            state.token = ''
        },

        setId: (state, action) => {
            state.id = action.payload;
        },

        unsetId: (state) => {
            state.id = 0;
        },

        setAuthentication: (state) => {
            state.isAuthenticated = true;
        },

        unsetAuthentication: (state) => {
            state.isAuthenticated = false;
        }
    }
})

export const { setToken, unsetToken, setAuthentication, unsetAuthentication, setId, unsetId } = userSlice.actions;
export default userSlice.reducer;