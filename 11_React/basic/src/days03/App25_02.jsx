// 
import React, { useState } from 'react'

function App() {

  const [allchecked, setAllchecked] = useState(false);
  const [form, setForm] = useState({
    agree: false,
    email: false,
    privacy: false
  });

  function handleAllChange(event){
    const checked = event.target.checked;
    setAllchecked(checked);

    setForm({
      agree: checked,
      email: checked,
      privacy: checked
    })
  }

  function handleChange(event){
    const key = event.target.name; // agree, email, privacy
    const value = event.target.checked;

    const newForm = {
      ...form, [key]: value
    }
    setForm((newForm));

    // 세 개 모두 체크되었는지 확인 -> 전체 선택 체크
    const allchecked = Object.values(newForm).every(
      (checked) => checked === true
    );

    setAllchecked(allchecked);

  }

  return (
    <>
      <h1>
        폼 <small>체크박스들</small>
      </h1>

      <div>
        <label>
          <input
            type="checkbox"
            onChange={handleAllChange}
            checked={allchecked}
          />{' '}
          전체 선택
        </label>
      </div>

      <div>
        <label>
          <input
            type="checkbox"
            name="agree"
            onChange={handleChange}
            checked={form.agree}
          />{' '}
          약관에 동의합니다.
        </label>
      </div>
      <div>
        <label>
          <input
            type="checkbox"
            name="email"
            onChange={handleChange}
            checked={form.email}
          />{' '}
          이메일 수신에 동의합니다.
        </label>
      </div>
      <div>
        <label>
          <input
            type="checkbox"
            name="privacy"
            onChange={handleChange}
            checked={form.privacy}
          />{' '}
          개인정보 처리방침에 동의합니다.
        </label>
      </div>
      <hr />
      <h2>현재 state값</h2>
      <p>{form.agree ? '약관 동의함' : '약관 동의 안함'}</p>
      <p>{form.email ? '수신 동의함' : '수신 동의 안함'}</p>
      <p>{form.privacy ? '개인정보 동의함' : '개인정보 동의 안함'}</p>
    </>
  )
}

export default App