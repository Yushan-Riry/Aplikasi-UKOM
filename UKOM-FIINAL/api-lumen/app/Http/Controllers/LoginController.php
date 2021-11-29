<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;

class LoginController extends Controller
{

    public function index()
    {
        $data = User::where('level', '<>', 'pelanggan')->get();

        return response()->json($data);
    }
    
    public function register(Request $request)
    {

        // $this->validate($request,[
        //     'nama'  => '=!0 | numeric | unique:users',
        //     'alamat' => 'required',
        //     'telp' => 'required',
        //     'sandi' => 'required | min:8'
        // ]);
        

        $data = [
            'nama'      => $request -> input('nama'),
            'alamat'    => $request -> input('alamat'),
            'telp'      => $request -> input('telp'),
            'sandi'     => $request -> input('sandi'),
            'email'     => 'uwu',
            'password'  => 'uwu',
            'level'     => 'uwu',
            'api_token' => 'uwu',
            'status'    => '1',
            'relasi'    => 'uwu'
        ];

        User::create($data);
        $datauser =[
            'pesan' => 'login berhasil',
            // 'token' => $token,
            'data'  => $data
        ];

        return response()->json($datauser);
    }

    public function login(Request $request)
    {
        $nama      = $request->input('nama');
        $sandi   = $request->input('sandi');

        $user = User::where('nama', $nama)->first();

        if (isset($user)) {
            if ($user -> status === 1) {
                if (($sandi && $nama)) {

                  
                    // $user->update([
                    //     'api_token' => $token
                    // ]);
        
                    return response()->json([
                        'pesan' => 'login berhasil',
                        // 'token' => $token,
                        'data'  => $user
                    ]);
        
                } else {
                    return response()->json([
                        'pesan' => 'login gagal',
                        'data'  => ''
                    ]);
                }
            } else {
                return response()->json([
                    'pesan' => 'login gagal',
                    'data'  => ''
                ]);
            }
        } else {
            return response()->json([
                'pesan' => 'login gagal',
                'data'  => ''
            ]);
        }
    }

    public function update(Request $request, $id)
    {
        //
        $user = User::where('id', $id)->update($request->all());

        if ($user) {
            return response()->json([
                'pesan' => "Data sudah di ubah !"
            ]);
        }
    }
}
