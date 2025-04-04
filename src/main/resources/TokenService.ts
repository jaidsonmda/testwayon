import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: "root",
})
export class TokenService {
    apiUrl = environment.API_URL;

    constructor(private http: HttpClient) {}

    hasToken() {
        return !!this.getToken();
    }

    setToken(tokenValue) {
        localStorage.setItem("token", `Bearer ${tokenValue}`);
    }

    getToken() {
        return localStorage.getItem("token");
    }

    resetToken(params) {
        return this.http.get(`${this.apiUrl}/login/token/autenticar`, {
            params: params,
        });
    }

    removeToken() {
        return localStorage.removeItem("token");
    }
}